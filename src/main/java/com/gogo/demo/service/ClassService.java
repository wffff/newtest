package com.gogo.demo.service;

import com.gogo.demo.dao.beans.Classroom;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface ClassService {
    public List<Classroom> findall();
    public boolean addClass(int id,String classname);
    public Classroom findByID(int id);
    public boolean modifyClass(int id,String classname);

   public boolean deleteClassByID(int id);
}
