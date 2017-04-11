package com.gogo.demo.service.impl;

import com.gogo.demo.dao.ClassDAO;
import com.gogo.demo.dao.beans.Classroom;
import com.gogo.demo.dao.impl.ClassDAOImpl;
import com.gogo.demo.dao.impl.StudentDAOImpl;
import com.gogo.demo.service.ClassService;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ClassServiceImpl implements ClassService{
private ClassDAO dao;
    @Override
    public List<Classroom> findall() {
        dao=new ClassDAOImpl();
        return dao.findall();
    }

    @Override
    public boolean addClass(int id, String classname) {
        dao=new ClassDAOImpl();
        if(findByID(id).getClassname()!=null){
            return false;
        }
        dao.addClass(id,classname);
        return true;
    }

    @Override
    public Classroom findByID(int id) {
        dao=new ClassDAOImpl();
        return dao.findByID(id);
    }

    @Override
    public boolean modifyClass(int id, String classname) {
        dao=new ClassDAOImpl();
        if(findByID(id).getClassname()==null){
            return false;
        }
        if(dao.updateClass(id,classname)){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean deleteClassByID(int id) {
        dao=new ClassDAOImpl();
        if(findByID(id).getClassname()==null){
            return false;
        }
        if(dao.deleteClass(id)){
            return true;
        }else{
            return false;
        }
    }
}
