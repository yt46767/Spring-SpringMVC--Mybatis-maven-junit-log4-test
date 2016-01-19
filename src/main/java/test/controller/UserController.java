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
  public String toIndex(HttpServletRequest request,Model model){  //备注：request——前端请求参数；model——前端页面文件
	  if( (request.getParameter("selectId").isEmpty()) == false ){
		  //查询, 访问地址：http://localhost:8080/test/user/showUser?selectId=1
	      int userId = Integer.parseInt(request.getParameter("selectId"));  
	      User user = this.userService.getUserById(userId);  
	      model.addAttribute("user", user);
	      return "showUser";
	  }else{
		  //删除, 访问地址：http://localhost:8080/test/user/showUser?selectId=&deleteId=1
		  if((request.getParameter("deleteId").isEmpty()) == false){
			  int userId = Integer.parseInt(request.getParameter("deleteId")); 
		      this.userService.deleteById(userId);  
			  return "showUser";
		  }else{
			  //插入, 访问地址：http://localhost:8080/test/user/showUser?selectId=&deleteId=&insertId=1&userName=xxxxx&password=000000&age=100
			  if((request.getParameter("insertId").isEmpty()) == false){

				  //数据写入User
				  User userOne = new User();
				  
				  userOne.setUserName(String.valueOf(request.getParameter("userName")));
				  userOne.setPassword(String.valueOf(request.getParameter("password")));
				  userOne.setAge(Integer.parseInt(request.getParameter("age")));
				  
			      this.userService.insertOne(userOne);  
				  return "showUser";
			  }else{
				  //修改, 访问地址：http://localhost:8080/test/user/showUser?selectId=&deleteId=&insertId=&updateId=1&id=6&userName=yyyyy&password=999999&age=0001
				  if((request.getParameter("updateId").isEmpty()) == false){

					  //数据写入User
					  User userOne = new User();
					  
					  userOne.setId(Integer.parseInt(request.getParameter("id")));
					  userOne.setUserName(String.valueOf(request.getParameter("userName")));
					  userOne.setPassword(String.valueOf(request.getParameter("password")));
					  userOne.setAge(Integer.parseInt(request.getParameter("age")));
					  
				      this.userService.updateById(userOne);  
					  return "showUser";
				  }else{
					  return "showUser";
				  }
			  }
		  }
	  }
  }  
}  