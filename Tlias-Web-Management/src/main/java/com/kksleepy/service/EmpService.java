package com.kksleepy.service;

import com.kksleepy.pojo.Emp;
import com.kksleepy.pojo.EmpQueryParam;
import com.kksleepy.pojo.LoginInfo;
import com.kksleepy.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {

    //    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    LoginInfo login(Emp emp);
}
