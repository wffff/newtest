package com.gogo.demo.controller;

import com.gogo.demo.biz.IStudentBiz;
import com.gogo.demo.biz.impl.StudentBiz;
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
public class DeleteStudent extends HttpServlet{
    private IStudentBiz ss;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    @RequestMapping("/deletestudent")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ss = new StudentBiz();
        String _id = req.getParameter("studentid").trim();
        int id = Integer.valueOf(_id);
        if (ss.deleteStudent(id)) {
            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    }
