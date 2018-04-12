package model;

import com.mysql.jdbc.*;
import com.sun.istack.internal.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import sun.util.logging.PlatformLogger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lam
 */
public class connectDB {

    public Connection con;
    public Statement st;
    public ResultSet rs;
    String sql;

    public connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01", "root", "");
            st = (Statement) con.createStatement();

        } catch (Exception ex) {
            System.out.print("Error:" + ex);
        }
    }

    public void getData() {
        try {
            String query = "select * from Diem";
            rs = st.executeQuery(query);
            System.out.print("\n Records from Database\n");
            while (rs.next()) {
                String name = rs.getString("hoten");
                String diemso = rs.getString("diem");
                int mark = Integer.parseInt(diemso);
                String major = rs.getString("chuyennganh");
                System.out.print("Họ tên: " + name + "\nĐiểm số: " + mark + "\nChuyên ngành: " + major);
            }
        } catch (Exception ex) {
            System.out.print("Eror: " + ex);
        }
    }

    
}
