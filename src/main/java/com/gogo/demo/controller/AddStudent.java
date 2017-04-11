package com.gogo.demo.controller;

import com.gogo.demo.service.StudentService;
import com.gogo.demo.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/4/7.
 */
@RestController
public class AddStudent extends HttpServlet{
    private StudentService ss;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    @RequestMapping("/addstudent")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   ss=new StudentServiceImpl();
   String _id=req.getParameter("studentid").trim();
   String name=req.getParameter("studentname").trim();
   String _cid=req.getParameter("studentclassid").trim();
   int id=Integer.valueOf(_id);
   int cid=Integer.valueOf(_cid);
   if(ss.addStudent(id,name,cid)){
       req.getRequestDispatcher("/success.jsp").forward(req,resp);
   }else{
       req.getRequestDispatcher("/error.jsp").forward(req,resp);
   }


    }
}
