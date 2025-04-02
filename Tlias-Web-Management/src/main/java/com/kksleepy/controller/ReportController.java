package com.kksleepy.controller;

import com.kksleepy.pojo.ClazzCountOption;
import com.kksleepy.pojo.JobOption;
import com.kksleepy.pojo.Result;
import com.kksleepy.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("查询员工工作数据");
        JobOption empJobData = reportService.getEmpJobData();
        return Result.success(empJobData);
    }

    @GetMapping("empGenderData")
    public Result getEmpGenderData(){
        log.info("查询员工性别数据");
        List<Map<String,Object>> empGenderData = reportService.getEmpGenderData();
        return Result.success(empGenderData);
    }
    /**
     * 统计学员的学历信息
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学员的学历信息");
        List<Map> dataList = reportService.getStudentDegreeData();
        return Result.success(dataList);
    }

    /**
     * 班级人数统计
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("班级人数统计");
        ClazzCountOption clazzCountOption = reportService.getStudentCountData();
        return Result.success(clazzCountOption);
    }
}
