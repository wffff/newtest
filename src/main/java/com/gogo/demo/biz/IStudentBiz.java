package com.gogo.demo.biz;


import com.gogo.demo.beans.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface IStudentBiz {
    public List<Student> findAll();

    public boolean addStudent(int id, String name, int cid);
    public Student findByID(int id);

    public boolean modifyStudent(int id, String name, int cid);

    public boolean deleteStudent(int id);
}
