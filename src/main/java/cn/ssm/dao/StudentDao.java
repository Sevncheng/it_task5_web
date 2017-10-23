package cn.ssm.dao;

import cn.ssm.entity.Student;

import java.util.List;

public interface StudentDao {
    public void add(Student student);
    public void delete(Student student);
    public void update(Student student);
    public List<Student> findAll();
    public Student findById(String id);
    public Student findByStudent(Student student);
    public Integer findByStates(String str);
    public Integer findByType(String str);
}