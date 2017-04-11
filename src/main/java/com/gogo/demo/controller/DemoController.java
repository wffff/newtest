package com.gogo.demo.controller;

import com.gogo.demo.dao.beans.Student;
import com.gogo.demo.service.StudentService;
import com.gogo.demo.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caowentao on 2017/2/28.
 */
@RestController
public class DemoController  extends HttpServlet {
    private StudentService ss;

    @Override
    @RequestMapping("/showstudent")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ss=new StudentServiceImpl();
        List<Student> list= ss.findAll();
        req.getSession().setAttribute("student",list);
        req.getRequestDispatcher("/detail.jsp").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}