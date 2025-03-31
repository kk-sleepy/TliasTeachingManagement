package com.kksleepy.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmpQueryParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10;  //每页展示数据
    private String name;    //员工姓名
    private Integer gender; //员工性别
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate begin;    //入职时间范围的开始时间
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate end;  //入职时间范围的结束时间
}
