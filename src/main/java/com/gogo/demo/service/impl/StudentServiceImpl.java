package com.gogo.demo.service.impl;

import com.gogo.demo.dao.StudentDAO;
import com.gogo.demo.dao.impl.StudentDAOImpl;
import com.gogo.demo.service.StudentService;
import com.gogo.demo.dao.beans.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public class StudentServiceImpl implements StudentService{
    private StudentDAO sd;
    @Override
    public List<Student> findAll() {
        sd=new StudentDAOImpl();
        return sd.findAll();
    }


    @Override
    public boolean addStudent(int id, String name, int cid) {
        sd=new StudentDAOImpl();
        if(findByID(id).getName()!=null){
            return false;
        }
    sd.addStudent(id,name,cid);
    return true;
    }

    @Override
    public Student findByID(int id) {
        sd=new StudentDAOImpl();
        return sd.findByID(id);
    }

    @Override
    public boolean modifyStudent(int id, String name, int cid) {
        sd=new StudentDAOImpl();
        if(findByID(id).getName()==null){
            return false;
        }
        if(sd.updateStudent(id,name,cid)){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean deleteStudent(int id) {
        sd=new StudentDAOImpl();
        if(findByID(id).getName()==null){
            return false;
        }
        if(sd.deletestudent(id)){
            return true;
        }else{
            return false;
        }
    }

}
