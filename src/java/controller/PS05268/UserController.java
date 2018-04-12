package controller.PS05268;

import model.connectDB;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import model.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
//	@RequestMapping("user/form")
//	public String showForm() {
//		return "index";
//	}
        @RequestMapping("index")
        public String index()
        {
            return "login";
        }
	@RequestMapping("login")
	public String login(HttpServletRequest request,ModelMap model) throws ClassNotFoundException, SQLException {
		String id = request.getParameter("email");
		String pw = request.getParameter("pass");
                model.login dn = new login();
		if(dn.checklogin(id, pw) == true){
                    request.setAttribute("uid", id);
                    request.setAttribute("pwd", pw);
                    model.addAttribute("message","Đăng nhập thành công");
                    return "manager";
                    
		}
		model.addAttribute("message", "Sai thông tin đăng nhập !");
		return "login";
	}
	
//	@RequestMapping("user/login")
//	public String login2(ModelMap model, HttpServletRequest request) throws SQLException, ClassNotFoundException {
//		String id = request.getParameter("email");
//		String pw = request.getParameter("pass");
//                model.login dn = new login();
//		if(dn.checklogin(id, pw) == true){
//			return "hello";
//		}
//                model.addAttribute("message", "Sai thông tin đăng nhập !");
//		return "hello";
//	}
}
