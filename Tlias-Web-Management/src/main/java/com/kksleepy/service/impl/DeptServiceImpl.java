package com.kksleepy.service.impl;

import com.kksleepy.mapper.DeptMapper;
import com.kksleepy.pojo.Dept;
import com.kksleepy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer deptId) {
        deptMapper.deleteById(deptId);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept getById(Integer deptId) {
        return deptMapper.getById(deptId);
    }

    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }
}
