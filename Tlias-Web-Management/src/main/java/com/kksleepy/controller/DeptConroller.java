package com.kksleepy.controller;

import com.kksleepy.pojo.Dept;
import com.kksleepy.pojo.Result;
import com.kksleepy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptConroller {
    @Autowired
    private DeptService deptService;

    /**
     * 部门列表查询
     *
     * @return Result
     */
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 部门删除
     * 一旦声明了@RequestParam，参数就必须传递，或者可以把required改为false
     * 如果前端传递的参数名和接收的参数名相同，则可以省略注解
     */
    @PostMapping("/depts")
    public Result delete(@RequestParam(value = "id", required = false) Integer DeptId) {
        System.out.println(DeptId);
        deptService.deleteById(DeptId);
        return Result.success();
    }
}
