package com.gogo.demo.controller;

import com.gogo.demo.dao.beans.Classroom;
import com.gogo.demo.dao.beans.Student;
import com.gogo.demo.service.ClassService;
import com.gogo.demo.service.StudentService;
import com.gogo.demo.service.impl.ClassServiceImpl;
import com.gogo.demo.service.impl.StudentServiceImpl;
import org.springframework.cglib.core.ClassesKey;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by caowentao on 2017/2/28.
 */
@RestController
public class ShowAll extends HttpServlet {
    private StudentService ss;

    @Override
    @RequestMapping("/showall")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ss=new StudentServiceImpl();
        List<Student> list= ss.findAll();
    ClassService cs=new ClassServiceImpl();
    for(int i=0;i<list.size();i++){
        list.get(i).setClassname(cs.findByID(list.get(i).getClass_id()).getClassname());
    }


        req.getSession().setAttribute("student",list);
        req.getRequestDispatcher("/detailAll.jsp").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}