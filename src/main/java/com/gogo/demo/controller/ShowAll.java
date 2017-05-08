package com.gogo.demo.controller;

import com.gogo.demo.beans.Student;
import com.gogo.demo.biz.IClassBiz;
import com.gogo.demo.biz.IStudentBiz;
import com.gogo.demo.biz.impl.ClassBiz;
import com.gogo.demo.biz.impl.StudentBiz;
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
    private IStudentBiz ss;

    @Override
    @RequestMapping("/showall")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ss=new StudentBiz();
        List<Student> list= ss.findAll();
    IClassBiz cs=new ClassBiz();
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