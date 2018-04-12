/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.PS05268;

import bean.Major;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import bean.Student;
import bean.depart;
import bean.Staff;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.File;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import model.data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author lam
 */
@Controller
@RequestMapping("staff-mgr")
public class StudentMgrController {
    @Autowired
    ServletContext context;
    @RequestMapping("index")
    public String index(@ModelAttribute("staff") Staff nv) {
        return "staff";
    }

    @RequestMapping(params="btnInsert")
    public String insert(@ModelAttribute("staff") Staff nv,ModelMap model) throws ClassNotFoundException, SQLException {
//           model.addAttribute("name",name);
//           model.addAttribute("mark",mark);
//           model.addAttribute("major",major);
        data dulieu = new data();
        dulieu.insertStaff(nv);
        model.addAttribute("message", "Bạn gọi insert()");
        List<Staff> list = new ArrayList<Staff>();
        list = data.showStaff("");
        model.addAttribute("listStaff", list);
        return "staff";
    }

    @RequestMapping(params="btnUpdate")
    public String update(@ModelAttribute("staff") Staff nv,ModelMap model) throws ClassNotFoundException, SQLException {
        data dulieu = new data();
        dulieu.updateData(nv);
        
        List<Staff> list = new ArrayList<Staff>();
        list = data.showStaff("");
        model.addAttribute("listStaff", list);
        return "staff";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model,
            @ModelAttribute("staff") Staff nv) throws ClassNotFoundException, SQLException {
        String ten = request.getParameter("txtID");
        data dulieu = new data();
        dulieu.deleteData(ten);

        List<Staff> list = new ArrayList<Staff>();
        list = data.showStaff("");
        model.addAttribute("listStaff", list);
        return "staff";
    }

    @RequestMapping("edit")
    public String edit(ModelMap model,
            @RequestParam("txtName") String name,
            @RequestParam("txtMark") Double mark,
            @RequestParam("txtMajor") String major) throws ClassNotFoundException, SQLException {
        Student sv = new Student(name, mark, major);
        model.addAttribute("student", sv);
        List<Staff> list = new ArrayList<Staff>();
        list = data.showStaff("");
        model.addAttribute("listStaff", list);
        return "staff";
    }

    @RequestMapping("showall")
    public String showAll(ModelMap model) {
        data dulieu = new data();
        List<Staff> list = new ArrayList<Staff>();
        list = dulieu.showStaff("");
        model.addAttribute("listStaff", list);
        Staff nv = new Staff();
        nv = list.get(0);
        model.addAttribute("staff", nv);
        return "staff";
    }

    @ModelAttribute("departs")
    public List<depart> getDeparts() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/as_ps05268_sof302", "root", "xlam2311@X");
        String sql = "select * from departs";

        Statement st = (Statement) con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<depart> departs = new ArrayList<>();
        while (rs.next()) {
            depart nganh = new depart(rs.getString("id"), rs.getString("name"));
            departs.add(nganh);
        }
        return departs;

    }
    @RequestMapping("apply")
    public String apply(ModelMap model, @RequestParam("fullname") String fullname, @RequestParam("photo") MultipartFile photo) {
        if (photo.isEmpty()) {
            model.addAttribute("message", "Vui lòng chọn file !");
        } else {
            try {
                String photoPath = context.getRealPath("/images/" + photo.getOriginalFilename());
                photo.transferTo(new File(photoPath));
                model.addAttribute("photo_name", photo.getOriginalFilename());
                
                return "staff";
            } catch (Exception e) {
                model.addAttribute("message", "Lỗi lưu file !");
            }
        }
        return "job/form";
    }
//    @ModelAttribute("majors")
//    public List<Student> getMajors() throws ClassNotFoundException, SQLException {
//        
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01", "root", "");
//            String sql = "select chuyennganh from diem";
//
//            Statement st = (Statement) con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            List<Student> majors = new ArrayList<>();
//            while (rs.next()) {
//                Student nganh = new Student(rs.getString("chuyennganh"));
//                majors.add(nganh);
//            }
//            return majors;
//        
//        
//    }

}
