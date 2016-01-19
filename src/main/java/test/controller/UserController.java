package test.controller;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  

import test.model.User;
import test.service.UserService;
import test.service.UserServiceImp;

/**
 * （存放控制层controller）
 * @author tony
 *
 */
@Controller  
@RequestMapping("/user")  
public class UserController {  
	
  @Autowired
  private UserServiceImp userService;  
    
  @RequestMapping("/showUser")  
  public String toIndex(HttpServletRequest request,Model model){  
      int userId = Integer.parseInt(request.getParameter("id"));  
      User user = this.userService.getUserById(userId);  
      model.addAttribute("user", user);  
      return "showUser";  
  }  
}  