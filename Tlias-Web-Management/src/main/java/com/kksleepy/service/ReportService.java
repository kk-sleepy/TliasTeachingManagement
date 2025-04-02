package com.kksleepy.service;

import com.kksleepy.pojo.ClazzCountOption;
import com.kksleepy.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    /**
     * 统计学历人数
     */
    List<Map> getStudentDegreeData();

    /**
     * 统计班级人数
     */
    ClazzCountOption getStudentCountData();
}
