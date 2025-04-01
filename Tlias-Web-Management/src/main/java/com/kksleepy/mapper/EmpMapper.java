package com.kksleepy.mapper;

import com.kksleepy.pojo.Emp;
import com.kksleepy.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
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

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
    "VALUES (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);


    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateById(Emp emp);
}
