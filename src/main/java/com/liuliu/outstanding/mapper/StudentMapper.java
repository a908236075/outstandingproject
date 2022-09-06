package com.liuliu.outstanding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuliu.outstanding.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liu_liu
 * @since 2022-09-06
 */
//@Mapper
@Repository
public interface StudentMapper extends BaseMapper<Student> {

}
