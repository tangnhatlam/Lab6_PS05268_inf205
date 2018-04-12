/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lam
 */
import bean.Major;
import bean.Student;
import bean.Staff;
import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class data {

    static Connection con;
    static Statement st;
    static ResultSet rs;
    static String sql;

    public void insertStaff(Staff nv) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/as_ps05268_sof302", "root", "xlam2311@X");
            String query = "insert into staffs values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre = (PreparedStatement) con.prepareStatement(query);
            pre.setInt(1, nv.getId());
            pre.setString(2, nv.getName());
            pre.setInt(3, nv.getGender());
            pre.setString(4, nv.getBirthday());
            pre.setString(5, nv.getPhoto());
            pre.setString(6, nv.getEmail());
            pre.setString(7, nv.getPhone());
            pre.setDouble(8, nv.getSalary());
            pre.setString(9, nv.getNotes());
            pre.setString(10, nv.getDeparts_id());
            pre.execute();
            con.close();
        } catch (SQLException ex) {
            System.out.print("Error: " + ex);
        }
    }

    public void updateData(Staff nv) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/as_ps05268_sof302", "root", "xlam2311@X");
            String query = "UPDATE diem set Id = , Name = ?,Gender = ?, Birthday = ?, Photo = ?,Email = ?, Phone = ?, Salary = ?, Notes = ?, Departs_id = ? where Id = ?";
            PreparedStatement pre = (PreparedStatement) con.prepareStatement(query);
            pre.setInt(1, nv.getId());
            pre.setString(2, nv.getName());
            pre.setInt(3, nv.getGender());
            pre.setString(4, nv.getBirthday());
            pre.setString(5, nv.getPhoto());
            pre.setString(6, nv.getEmail());
            pre.setString(7, nv.getPhone());
            pre.setDouble(8, nv.getSalary());
            pre.setString(9, nv.getNotes());
            pre.setString(10, nv.getDeparts_id());
            pre.setInt(11, nv.getId());
            pre.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.print("Error: " + ex);
        }
    }

    public void deleteData(String name) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/as_ps05268_sof302","root","xlam2311@X");
            String query = "delete from staffs where Id = '" + name + "'";
            PreparedStatement pre = (PreparedStatement) con.prepareStatement(query);
            pre.executeUpdate(query);
            con.close();
        } catch (SQLException ex) {
            System.out.print("Error: " + ex);
        }
    }

    public static List<Staff> showStaff(String tensp) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/as_ps05268_sof302", "root", "xlam2311@X");
            String sql = "select * from staffs";
            if (tensp.length() > 0) {
                sql += " where Name like N'%" + tensp + "%'";
            }
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Staff> list = new ArrayList<Staff>();
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Integer gender = rs.getInt(3);
                String birthday = rs.getString(4);
                String photo = rs.getString(5);
                String email = rs.getString(6);
                String phone = rs.getString(7);
                double salary = rs.getDouble(8);
                String notes = rs.getString(9);
                String departs_id = rs.getString(10);
                Staff nv = new Staff(id, name, gender, birthday, photo, email, phone, salary, notes, departs_id);
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
