/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.PS05268;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lam
 */
@Controller
@RequestMapping("/manager/")
public class ManagerController {
    @RequestMapping("staffs")
    public String staffs()
        {
            return "staff";
        } 
    @RequestMapping("departs")
    public String departs()
        {
            return "depart";
        } 
}
