package com.kksleepy.service;

import com.kksleepy.pojo.Emp;
import com.kksleepy.pojo.EmpQueryParam;
import com.kksleepy.pojo.PageResult;

import java.time.LocalDate;


public interface EmpService {

    //    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult<Emp> page(EmpQueryParam empQueryParam);
}
