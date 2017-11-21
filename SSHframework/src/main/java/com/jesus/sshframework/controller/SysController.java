package com.jesus.sshframework.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jesus.sshframework.constant.SysConstant;
import com.jesus.sshframework.model.User;
import com.jesus.sshframework.service.IUserService;
import com.jesus.sshframework.util.MD5Util;

@Controller
@RequestMapping("/sys")
public class SysController {
    
    @Resource
    private IUserService userService;
    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value="/login.do",method = {RequestMethod.GET})
    public String toLogin(){
        return "login";
    }
    /**
     * 登录
     * @param request
     * @param userName
     * @param password
     * @param mv
     * @return
     */
    @RequestMapping(value = "/login.do",method = {RequestMethod.POST})
    public ModelAndView login(HttpServletRequest request,
                        @RequestParam(required=true)String userName,
                        @RequestParam(required=true)String password,
                        @RequestParam(required=true)String verifycode,
                        ModelAndView mv){
        boolean hasErr = true;
        String usermsg ="";
        String pwdmsg = "";
        String vercode = "";
        String sessioncode = (String) request.getSession().getAttribute("VALIDATECODESESSION");
        
        //MD5加密
        String secretPwd  = MD5Util.encrypByMd5(password);
        User user = userService.findEntityUserByName(userName);
        if(! sessioncode.equalsIgnoreCase(verifycode)){
            vercode = "验证码错误";
        }else if(user == null){
            usermsg = "用户不存在";
        }else if(! user.getPassword().equals(secretPwd)){
            pwdmsg = "用户密码不正确";
        }else{
            hasErr = false;
        }
        if(! hasErr){
        
//            //------------------------15122538314/123
//            User user = new User();
//            user.setUsername("1312321122");
//            user.setChannel("sa0000144");
//            user.setPassword("use");
//            user.setUserType("system");
//            //--------------测试代码-----
            
            mv.addObject("loguser", user);
            request.getSession().setAttribute(SysConstant.SESSION_USER, user);
            request.getSession().setAttribute("username", user.getUsername());
            mv= new ModelAndView("redirect:/def/index.do");
        }else {
            mv.addObject("usermsg",usermsg);
            mv.addObject("pwdmsg",pwdmsg);
            mv.addObject("vercode",vercode);
            mv.addObject("username",userName);
            mv.addObject("password",password);
            mv.setViewName("login");
        }
        return mv;
    }
    /**
     * 登出
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout.do",method = {RequestMethod.GET})
    public String logout(HttpServletRequest request){
        request.removeAttribute("loguser");
        request.getSession().removeAttribute("username");
        return "login";
    }

    @RequestMapping(value="/toBindUser.do",method =  {RequestMethod.GET})
    public String toBindUser(){
        return "bindUser";
    }
    
    @RequestMapping(value="/toChangePwd.do",method =  {RequestMethod.GET})
    public String toChnagePwd(){
        return "changePwd";
    }
    
    @RequestMapping(value="/changePwd.do",method= {RequestMethod.POST})
    @ResponseBody
    public String changePwd(String username,String newpwd){
        String ret ="";
        User userdb = userService.findEntityUserByName(username);
        if(userdb == null){
            ret = "hasuser";
        }else{
            userdb.setPassword(MD5Util.encrypByMd5(newpwd));
            userService.update(userdb);
            ret = "success";
        }
        return ret;
    }
    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value="/bindUser.do",method =  {RequestMethod.POST})
    @ResponseBody
    public String addUser(User user){
        String ret = "";
        boolean hasUser = userService.findUserByName(user.getUsername());
        if(hasUser){
           ret = "haveuser"; 
        }else{
            String scretePwd = MD5Util.encrypByMd5(user.getPassword());
            user.setPassword(scretePwd);
            userService.save(user);
            ret = user.getId();
        }
        return ret;
    }
    @RequestMapping(value="/toDetailUser/{id}")
    public ModelAndView toDetailUser(@PathVariable String id){
        ModelAndView mv = new ModelAndView();
        User user = userService.get(id);
        mv.addObject("user",user);
        mv.setViewName("userdetail");
        return mv;
    }
}
