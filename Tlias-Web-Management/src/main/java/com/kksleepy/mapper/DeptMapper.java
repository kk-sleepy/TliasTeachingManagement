package com.kksleepy.mapper;

import com.kksleepy.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    //查询所有部门数据
    @Select("select id, name, create_time, update_time from dept ORDER BY update_time desc;")
    List<Dept> findAll();

    @Delete("delete from dept where id = #{deptId}")
    void deleteById(Integer deptId);

    @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{deptId}")
    Dept getById(Integer deptId);

    @Update("update dept set name = #{name} where id = #{id}")
    void update(Dept dept);
}
