package com.liuliu.outstanding.service.impl;

import com.liuliu.outstanding.entity.Student;
import com.liuliu.outstanding.mapper.StudentMapper;
import com.liuliu.outstanding.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liu_liu
 * @since 2022-09-06
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
