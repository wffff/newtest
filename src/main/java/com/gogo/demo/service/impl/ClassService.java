package com.gogo.demo.service.impl;

import com.gogo.demo.beans.Classroom;
import com.gogo.demo.common.DBUtils;
import com.gogo.demo.common.JDBCOperation;
import com.gogo.demo.service.IClassService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ClassService implements IClassService {
    Connection conn = null;
    PreparedStatement pre = null;
    ResultSet rs = null;

    @Override
    public List<Classroom> findall() {
        conn = JDBCOperation.getConn();
        String sql = "select * from classroom order by id ASC ";
        List<Classroom> list=new ArrayList<>();
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while(rs.next()){
                Classroom cl=new Classroom();
                cl.setId(rs.getInt("id"));
                cl.setClassname(rs.getString("classname"));
                list.add(cl);
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(conn,pre,rs);
        return list;
    }

    @Override
    public boolean addClass(int id, String classname) {
        conn = JDBCOperation.getConn();
        String sql = "INSERT INTO classroom(id,classname)VALUES(?,?);";
        int rows=0;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            pre.setString(2,classname);
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
    public Classroom findByID(int id) {
        conn = JDBCOperation.getConn();
        String sql = "select * from classroom where id=?";
        Classroom cl=new Classroom();
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1,id);
            rs = pre.executeQuery();

            while(rs.next()){
                cl.setId(rs.getInt("id"));
                cl.setClassname(rs.getString("classname"));
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(conn,pre,rs);
        return cl;
    }

    @Override
    public boolean updateClass(int id, String classname) {
        conn = JDBCOperation.getConn();
        String sql = "UPDATE classroom set classname=? WHERE id = ?";
        int rows=0;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, classname);
            pre.setInt(2,id);
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
    public boolean deleteClass(int id) {
        conn = JDBCOperation.getConn();
        String sql = "DELETE FROM classroom WHERE ID=? ";
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
