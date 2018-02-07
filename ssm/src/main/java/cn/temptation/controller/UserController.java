package cn.temptation.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.temptation.model.User;
import cn.temptation.service.UserService;

/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 跳转到添加用户界面
     * @return
     */
    @RequestMapping("/toAddUser")
    public String toAddUser() {
        return "addUser";
    }

    /**
     * 添加用户并重定向
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(Model model,User user) {
    	if(user != null) {
    		userService.saveUser(user);
    	}
        return "redirect:/user/userInfo";
    }

    /**
     * 编辑用户
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(Model model,User user) {
        if(userService.updateUser(user)) {
        	user = userService.findByUserid(user.getUserid());
        	model.addAttribute("user", user);
        	return "redirect:/user/userInfo";
        }
        return "/error";
    }
    
    /**
     * 查询所有的用户
     * @return
     */
    @RequestMapping("/getAllUser")
    public String getAllUser(Model model) {
    	List<User> userList = userService.findAll();
    	model.addAttribute("user", userList);
    	return "allUser";
    }
    
    /**
     * 查询单个用户
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("/getUser")
    public String getUser(String userid,Model model) {
    	User user = userService.findByUserid(userid);
    	model.addAttribute("user",user);
    	return "editUser";
    }
    /**
     * 根据username删除用户
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("/delUser")
    public String deleteUser(String userid,Model model) {
    	model.addAttribute("user", userService.deleteUser(userid));
    	return "redirect:/user/userInfo";
    }
    /**
     * 分页查询用户信息
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("userInfo")
    public String getUsers(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {
    	//从第一条开始 每页查询五条数据
    	PageHelper.startPage(pn, 5);
    	List<User> users = userService.findAll();
    	//将用户信息放入PageInfo对象里
    	PageInfo page = new PageInfo(users,5);
    	model.addAttribute("pageInfo",page);
    	return "allUser";
    }
    
    
}