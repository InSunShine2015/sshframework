package com.jesus.sshframework.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jesus.sshframework.model.User;
import com.jesus.sshframework.service.IUserService;
import com.jesus.sshframework.util.MD5Util;

public class SysInitData {
    private static final Logger LOG = LoggerFactory.getLogger(SysInitData.class);
    @Resource
    private IUserService userService;
    
    private void initData(){
        LOG.info("=======================");
        LOG.info("===INIT SYS USER DATA==");
        LOG.info("=======================");
        User admin = userService.findEntityUserByName("ysadmin");
        if(admin == null){
            admin = new User();
            admin.setUsername("ysadmin");
            admin.setChannel("");
            admin.setPassword(MD5Util.encrypByMd5("1234qwer"));
            admin.setUserType("system");
            userService.save(admin);
            LOG.info("========ADD A SYS USER========");
        }
    }
}
