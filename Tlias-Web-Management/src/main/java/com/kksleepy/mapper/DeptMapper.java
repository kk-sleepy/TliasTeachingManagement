package com.kksleepy.mapper;

import com.kksleepy.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    //查询所有部门数据
    @Select("select id, name, create_time, update_time from dept ORDER BY update_time desc;")
    List<Dept> findAll();

    @Delete("delete from dept where id = #{deptId}")
    void deleteById(Integer deptId);
}
