package com.kksleepy.service;

import com.kksleepy.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门
     * @return List<Dept>
     */
    List<Dept> findAll();

    /**
     * 通过id删除部门
     * @param deptId
     */
    void deleteById(Integer deptId);
}
