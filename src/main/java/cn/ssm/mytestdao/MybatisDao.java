package cn.ssm.mytestdao;

import cn.ssm.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MybatisDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public void add(Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.student.add", student);
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.student.delete", student);
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.student.update", student);
        sqlSession.commit();
        sqlSession.close();
    }

    public List<Student> findAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Student> list = sqlSession.selectList("test.student.findAll");
        return list;
    }

    public Student findById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student = sqlSession.selectOne("test.student.findById", id);
        return student;
    }

    public Student findByStudent (Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student  temp = sqlSession.selectOne("test.student.findByStudent",student);
        return temp;
    }

}
