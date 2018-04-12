/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.PS05268;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import bean.Student;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import model.connectDB;
import model.data;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author lam
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @RequestMapping(value= "student",method=RequestMethod.GET)
    public String showForm()
    {
        return "student/form";
    }
    @RequestMapping(value="student",method=RequestMethod.POST)
    public String saveData(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String mark = request.getParameter("mark");
        String major = request.getParameter("major");
        
        request.setAttribute("name", name);
        request.setAttribute("mark", mark);
        request.setAttribute("major", major);
          
        return "student/success";
    }
    @RequestMapping("/info")
    public String showInfo(HttpServletRequest request)
    {
        connectDB con = new connectDB();
        con.getData();
        return "student/info";
    }
    @RequestMapping("/index")
    public String index(ModelMap model)
    {
        Student student = new Student("Nguyễn Văn Tèo",9.5,"WEB");
        model.addAttribute("student",student);
        return "student/student";
    }
//    
}
