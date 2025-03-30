package com.kksleepy.service;

import com.kksleepy.pojo.Emp;
import com.kksleepy.pojo.PageResult;
import org.springframework.stereotype.Service;


public interface EmpService {

    PageResult<Emp> page(Integer page, Integer pageSize);
}
