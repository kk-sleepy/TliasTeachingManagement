package com.kksleepy.controller;

import com.kksleepy.anno.Log;
import com.kksleepy.pojo.Dept;
import com.kksleepy.pojo.Result;
import com.kksleepy.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("depts")
public class DeptConroller {
    @Autowired
    private DeptService deptService;

    /**
     * 部门列表查询
     *
     * @return Result
     */
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 部门删除
     * 一旦声明了@RequestParam，参数就必须传递，或者可以把required改为false
     * 如果前端传递的参数名和接收的参数名相同，则可以省略注解
     */
    @Log
    @DeleteMapping
    public Result delete(@RequestParam(value = "id", required = false) Integer DeptId) {
        log.info("要删除的部门id: {}", DeptId);
        deptService.deleteById(DeptId);
        return Result.success();
    }

    /**
     * 需要保证封装对象中包含JSON数据的属性，可多不可少
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门信息: {}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id返回部门值
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer deptId) {
        log.info("要查询的id：{}", deptId);
        Dept dept = deptService.getById(deptId);
        return Result.success(dept);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("要更新的数据：{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
