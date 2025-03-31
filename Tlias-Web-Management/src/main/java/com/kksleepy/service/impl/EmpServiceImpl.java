package com.kksleepy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kksleepy.mapper.EmpMapper;
import com.kksleepy.pojo.Emp;
import com.kksleepy.pojo.EmpQueryParam;
import com.kksleepy.pojo.PageResult;
import com.kksleepy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    //插件版分页
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        List<Emp> rows = empMapper.list(empQueryParam);
        Page<Emp> p = (Page<Emp>)rows;
        return new PageResult<>(p.getTotal(),p.getResult());
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
