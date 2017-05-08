package com.gogo.demo.service;


import com.gogo.demo.beans.Classroom;

import java.util.List;

/**
 * Created by Administrator on 2 jhbhjk017/4/7.
 * Created by Administrator on 2017/    llkk4/7.
 */
public interface IClassService {



    public List<Classroom> findall();
    public boolean addClass(int id,String classname);
    public Classroom findByID(int id);
    public boolean updateClass(int id,String classname);

   public boolean deleteClass(int id);
}
