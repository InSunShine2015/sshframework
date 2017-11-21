package com.jesus.sshframework.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jesus.sshframework.model.User;
import com.jesus.sshframework.vo.Menu;

@Controller
@RequestMapping("/def")
public class DefaultController {
    /**
     * 加载首页
     * @param request
     * @return
     */
    @RequestMapping(value="/index",method=RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request){
        
        ModelAndView mv = new ModelAndView();
        //取出session中的用户
        User user = (User) request.getSession().getAttribute("loguser");
        mv.addObject("loguser", user);
        mv.setViewName("def/index");
        return mv;
    }
    
    
    /**
     * 加载首页头
     * @return
     */
    @RequestMapping(value = "/top/"  ,method = RequestMethod.GET)
    public String top(){   
        return "def/top";
    }
    /**
     * 加载首页左侧
     * @param request
     * @return
     */
    @RequestMapping(value = "/left/"  ,method = RequestMethod.GET)
    public ModelAndView left(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        List<Menu> menus = new ArrayList<Menu>();
        menus.add(new Menu("用户功能",""));
        menus.add(new Menu("渠道文件上传","/uploadExcel/toUpload.do"));
        menus.add(new Menu("渠道查询","/uploadExcel/toQueryChannel.do"));
        User user = (User) request.getSession().getAttribute("loguser");
        if("system".equals(user.getUserType())){
            menus.add(new Menu("系统功能",""));
            menus.add(new Menu("绑定用户","/sys/toBindUser.do"));
            menus.add(new Menu("重置密码","/sys/toChangePwd.do"));
        }
        mv.addObject("mns",menus);
        mv.setViewName("def/left");
        return mv;
    }
    /**
     * 加载首页右侧
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/right/"  ,method = RequestMethod.GET)
    public ModelAndView right()throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("nowDate", new Date());
        mv.setViewName("def/right");
        return mv;
    }
}
