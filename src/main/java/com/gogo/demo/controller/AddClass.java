package com.gogo.demo.controller;

import com.gogo.demo.biz.IClassBiz;
import com.gogo.demo.biz.impl.ClassBiz;
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
public class AddClass extends HttpServlet{
    private IClassBiz cs;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    @RequestMapping("/addclass")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cs=new ClassBiz();
   String _id=req.getParameter("classid").trim();
   String classname=req.getParameter("classname").trim();
   int id=Integer.valueOf(_id);
   if(cs.addClass(id,classname)){
       req.getRequestDispatcher("/success.jsp").forward(req,resp);
   }else{
       req.getRequestDispatcher("/error.jsp").forward(req,resp);
   }


    }
}
