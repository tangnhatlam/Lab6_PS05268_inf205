/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lam
 */
public class login {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    String sql;
    public boolean checklogin(String user, String pass) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/as_ps05268_sof302", "root", "xlam2311@X");
        st = (Statement) con.createStatement();
        boolean tmp = false;
        try {
            st = (Statement) con.createStatement();
            rs = st.executeQuery("select * from user where Username= '" + user + "' and Password= '" + pass+"'");
            if (rs.next()) {
                
                return tmp = true;
            }
        } catch (SQLException ex) {
            System.out.print("Error: " + ex);
        }
        return tmp;
    }
}
