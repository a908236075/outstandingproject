package com.liuliu.outstanding.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuliu.outstanding.entity.Student;
import com.liuliu.outstanding.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liu_liu
 * @since 2022-09-06
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/list")
    public void getList() {
        BaseMapper<Student> baseMapper = studentService.getBaseMapper();
        List<Student> students = baseMapper.selectList(new QueryWrapper<>());
        students.stream().forEach(System.out::println);
    }


}
