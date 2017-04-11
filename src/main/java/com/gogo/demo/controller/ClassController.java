package com.gogo.demo.controller;

import com.gogo.demo.dao.beans.Classroom;
import com.gogo.demo.dao.beans.Student;
import com.gogo.demo.service.ClassService;
import com.gogo.demo.service.impl.ClassServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
@RestController
public class ClassController extends HttpServlet {
    private ClassService cs;

    @Override
    @RequestMapping("/showclass")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    cs=new ClassServiceImpl();
        List<Classroom> list= cs.findall();
        req.getSession().setAttribute("classroom",list);
        req.getRequestDispatcher("/classDetail.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
