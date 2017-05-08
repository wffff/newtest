package com.gogo.demo.biz.impl;

import com.gogo.demo.beans.Classroom;
import com.gogo.demo.biz.IClassBiz;
import com.gogo.demo.service.IClassService;
import com.gogo.demo.service.impl.ClassService;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ClassBiz implements IClassBiz {
private IClassService dao;
    @Override
    public List<Classroom> findall() {
        dao=new ClassService();
        return dao.findall();
    }

    @Override
    public boolean addClass(int id, String classname) {
        dao=new ClassService();
        if(findByID(id).getClassname()!=null){
            return false;
        }
        dao.addClass(id,classname);
        return true;
    }

    @Override
    public Classroom findByID(int id) {
        dao=new ClassService();
        return dao.findByID(id);
    }

    @Override
    public boolean modifyClass(int id, String classname) {
        dao=new ClassService();
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
        dao=new ClassService();
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
