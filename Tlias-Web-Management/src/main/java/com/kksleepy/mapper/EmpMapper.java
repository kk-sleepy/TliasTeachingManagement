package com.kksleepy.mapper;

import com.kksleepy.pojo.Emp;
import com.kksleepy.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 操作员工基本信息
 */
@Mapper
public interface EmpMapper {
    /**
     *查询总记录数
     */

    /**
     * 分页查询无插件版
     */
//    @Select("select count(*) from emp e left outer join dept d on e.dept_id = d.id;")
//    public Long count();
//    @Select("select e.*,d.name deptName from emp e left outer join dept d on e.dept_id = d.id" +
//            " order by e.update_time desc limit #{start},#{pageSize};")
//    public List<Emp> list(Integer start, Integer pageSize);

    /**
     * 分页查询插件版
     */

    public List<Emp> list(EmpQueryParam empQueryParam);
}
