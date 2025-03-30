package com.kksleepy.service.impl;

import com.kksleepy.mapper.EmpMapper;
import com.kksleepy.pojo.Emp;
import com.kksleepy.pojo.PageResult;
import com.kksleepy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        Integer start = (page-1)*pageSize;
        long total = empMapper.count();
        List<Emp> rows = empMapper.list(start,pageSize);
        return new PageResult<Emp>(total,rows);
    }
}
