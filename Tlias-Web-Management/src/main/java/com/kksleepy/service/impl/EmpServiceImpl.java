package com.kksleepy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kksleepy.mapper.EmpExprMapper;
import com.kksleepy.mapper.EmpMapper;
import com.kksleepy.pojo.*;
import com.kksleepy.service.EmpLogService;
import com.kksleepy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;
    //插件版分页
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> rows = empMapper.list(empQueryParam);
        Page<Emp> p = (Page<Emp>)rows;
        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            List<EmpExpr> exprList = emp.getExprList();
            empMapper.insert(emp);
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach((expr)->{
                    expr.setEmpId(emp.getId());
                });
                empExprMapper.insert(exprList);
            }
        } finally {
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"新增员工信息: " + emp);
            empLogService.insertLog(empLog);
        }
    }

    /**
     * 分页操作无插件版
     */
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        Integer start = (page-1)*pageSize;
//        long total = empMapper.count();
//        List<Emp> rows = empMapper.list(start,pageSize);
//        return new PageResult<Emp>(total,rows);
//    }
}
