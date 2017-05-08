package com.gogo.demo.service;


import com.gogo.demo.beans.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface IStudentService {
    public List<Student> findAll();

   public  Student findByID(int id);

    public boolean addStudent(int id, String name, int cid);

   public boolean updateStudent(int id, String name, int cid);

    public boolean deletestudent(int id);
}
