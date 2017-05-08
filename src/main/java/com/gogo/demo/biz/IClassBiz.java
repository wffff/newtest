package com.gogo.demo.biz;


import com.gogo.demo.beans.Classroom;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface IClassBiz {
    public List<Classroom> findall();
    public boolean addClass(int id,String classname);
    public Classroom findByID(int id);
    public boolean modifyClass(int id,String classname);

   public boolean deleteClassByID(int id);
}
