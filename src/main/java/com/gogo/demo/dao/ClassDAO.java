package com.gogo.demo.dao;

import com.gogo.demo.dao.beans.Classroom;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface ClassDAO {

    public List<Classroom> findall();
    public boolean addClass(int id,String classname);
    public Classroom findByID(int id);
    public boolean updateClass(int id,String classname);

   public boolean deleteClass(int id);
}
