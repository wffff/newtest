package com.gogo.demo.service.impl;

import com.gogo.demo.beans.Student;
import com.gogo.demo.common.DBUtils;
import com.gogo.demo.common.JDBCOperation;
import com.gogo.demo.service.IStudentService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 2017/4/7.
 */
public class StudentService implements IStudentService {

    Connection conn = null;
    PreparedStatement pre = null;
    ResultSet rs = null;
    @Override
    public List<Student> findAll() {
        conn = JDBCOperation.getConn();
        String sql = "select * from student order by id ASC ";
        List<Student> list=new ArrayList<>();
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while(rs.next()){
                Student sd=new Student();
                sd.setId(rs.getInt("id"));
                sd.setName(rs.getString("name"));
                sd.setClass_id(rs.getInt("class_id"));
                list.add(sd);
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            DBUtils.close(conn,pre,rs);
        return list;
    }

    @Override
    public Student findByID(int id) {
        conn = JDBCOperation.getConn();
        String sql = "select * from student where id=?";
        Student sd=new Student();
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1,id);
            rs = pre.executeQuery();

            while(rs.next()){
                sd.setId(rs.getInt("id"));
                sd.setName(rs.getString("name"));
                sd.setClass_id(rs.getInt("class_id"));
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(conn,pre,rs);
    return sd;
    }

    @Override
    public boolean addStudent(int id, String name, int cid) {
        conn = JDBCOperation.getConn();
        String sql = "INSERT INTO student(id,name,class_id)VALUES(?,?,?)";
        int rows=0;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            pre.setString(2,name);
            pre.setInt(3,cid);
           rows=pre.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        DBUtils.close(conn, pre, rs);
        if(rows>0){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean updateStudent(int id, String name, int cid) {
        conn = JDBCOperation.getConn();
        String sql = "UPDATE student set name =? , class_id=? WHERE id = ?";
        int rows=0;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setInt(2,cid);
            pre.setInt(3,id);
            rows=pre.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        DBUtils.close(conn, pre, rs);
        if(rows>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deletestudent(int id) {
        conn = JDBCOperation.getConn();
        String sql = "DELETE FROM student WHERE id=? ";
        int rows=0;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            rows=pre.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        DBUtils.close(conn, pre);
        if(rows>0){
            return true;
        }else{
            return false;
        }
    }
}
