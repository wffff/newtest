package com.gogo.demo.controller;

import com.gogo.demo.beans.Classroom;
import com.gogo.demo.biz.IClassBiz;
import com.gogo.demo.biz.impl.ClassBiz;
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
    private IClassBiz cs;

    @Override
    @RequestMapping("/showclass")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    cs=new ClassBiz();
        List<Classroom> list= cs.findall();
        req.getSession().setAttribute("classroom",list);
        req.getRequestDispatcher("/classDetail.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
