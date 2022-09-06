package com.liuliu.outstanding.httpClient;

import com.liuliu.outstanding.entity.Student;
import com.liuliu.outstanding.mapper.StudentMapper;
import com.liuliu.outstanding.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.TestPropertySource;

//@SpringBootTest
//@DataJpaTest
@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class JDBCTest {

   /* @TestConfiguration
    static class StudentJDBCClass {
        @Bean
        public static IStudentService iStudentService() {
            return new StudentServiceImpl();
        }
    }*/

    @Autowired
    IStudentService iStudentService;
    /*@Autowired
    StudentMapper studentMapper;*/

    @Test
    public void mockTest() {
      /*  IStudentService iStudentService = StudentJDBCClass.iStudentService();
        Student stu = iStudentService.getById(1);
        System.out.println(stu);*/
       /* List<Student> students = iStudentService.selectList(new QueryWrapper<>());
        students.stream().forEach(System.out::println);*/
        /*Student student = studentMapper.selectById(2);
        System.out.println(student);*/
    }
   /* @Autowired
    Student student;*/
    @Test
    public void studentTest() {
        /*Student liu_liu = student.setName("liu_liu");
        System.out.println(liu_liu.getName());*/
    }


}
