package cn.ssm.service.impl;

import cn.ssm.dao.StudentDao;
import cn.ssm.entity.Student;
import cn.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mybatisService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    public void add(Student student){
        studentDao.add(student);
    }
    public void delete(Student student){
        studentDao.delete(student);
    }
    public void update(Student student){
        studentDao.update(student);
    }
    public List<Student> findAll(){
        return studentDao.findAll();
    }
    public Student findById(String id){ return studentDao.findById(id);};
    public Student findByStudent(Student student){ return studentDao.findByStudent(student);}

    @Override
    public Integer findByStates(String str) {
        return studentDao.findByStates(str);
    }

    @Override
    public Integer findByType(String str) {
        return studentDao.findByType(str);
    }

    ;

}
