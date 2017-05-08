package com.gogo.demo.biz.impl;

import com.gogo.demo.beans.Student;
import com.gogo.demo.biz.IStudentBiz;
import com.gogo.demo.service.IStudentService;
import com.gogo.demo.service.impl.StudentService;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public class StudentBiz implements IStudentBiz {
    private IStudentService sd;
    @Override
    public List<Student> findAll() {
        sd=new StudentService();
        return sd.findAll();
    }


    @Override
    public boolean addStudent(int id, String name, int cid) {
        sd=new StudentService();
        if(findByID(id).getName()!=null){
            return false;
        }
    sd.addStudent(id,name,cid);
    return true;
    }

    @Override
    public Student findByID(int id) {
        sd=new StudentService();
        return sd.findByID(id);
    }

    @Override
    public boolean modifyStudent(int id, String name, int cid) {
        sd=new StudentService();
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
        sd=new StudentService();
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
