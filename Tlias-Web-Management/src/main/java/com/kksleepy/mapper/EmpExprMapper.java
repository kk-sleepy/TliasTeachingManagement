package com.kksleepy.mapper;

import com.kksleepy.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工工作经历操作
 */
@Mapper
public interface EmpExprMapper {
    void insert(List<EmpExpr> exprList);
}
