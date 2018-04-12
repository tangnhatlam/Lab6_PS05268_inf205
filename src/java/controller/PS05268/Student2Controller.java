package controller.PS05268;

import bean.Major;
import bean.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.data;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student2/")
public class Student2Controller {

    static Connection con;
    static Statement st;
    static ResultSet rs;
    static String sql;

    @RequestMapping("edit")
    public String edit(ModelMap model) {
        Student sv = new Student("Nguyễn Thị Tám", 8.3, "WEB");
        model.addAttribute("student", sv);
        return "student/student2";
    }

    @RequestMapping("update")
    public String update(@ModelAttribute("student") Student student) {
        return "student/student2";
    }

    @ModelAttribute("majors")
    public List<Major> getMajors() throws ClassNotFoundException, SQLException {
        
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01", "root", "");
            String sql = "select * from major";

            st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Major> majors = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("id");
                String cn = rs.getString("name");

                Major nganh = new Major(id, cn);
                majors.add(nganh);
            }
            return majors;
        
        
    }

    /*
	 * Xử dụng mảng
	 *	
     */
//	@ModelAttribute("majors")
//	public String[] getMajors() {
//		String[] majors = {
//				"Ứng dụng phần mềm",
//				"Thiết kế trang web"
//		};
//		return majors;
//	}
    /*
	 * Xử dụng List<String>
	 *
	@ModelAttribute("majors")
	public List<String> getMajors() {
		List<String> majors = new ArrayList<>();
		majors.add("Ứng dụng phần mềm");
		majors.add("Thiết kế trang web");
		return majors;
	}
     */
 /*
	 * Xử dụng Map<String, String>
	 *
     */
//        @ModelAttribute("majors")
//	public Map<String, String> getMajors() {
//		Map<String, String> majors = new HashMap<>();
//		majors.put("APP", "Ứng dụng phần mềm");
//		majors.put("WEB", "Thiết kế trang web");
//		return majors;
//	}
}
