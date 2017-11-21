package com.jesus.sshframework.web;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletContextAware;

public class ResourceExposer implements ServletContextAware{
    
    private static final Logger LOG = LoggerFactory.getLogger(ResourceExposer.class);
    
    private ServletContext application;
    /** 站点根路径 **/
    private String webRoot;
    /** 图片资源根路径 **/
    private String imageRoot;
    /** css资源根路径 **/
    private String cssRoot;
    /** 页面工具集根路径 **/
    private String toolRoot;
    /** js资源根路径 **/
    private String jsRoot;
    /** sso服务端路径 **/
    private String ssoRoot;
    /** 文件上传物理路径  **/
    private String fileRoot;
    /** 上传文件的http根目录 **/
    private String uploadRoot;
    /*
     * 初始化方法
     */
    public void init() throws Exception {
        LOG.info("init system resources ....");
        getServletContext().setAttribute("webRoot", webRoot);
        getServletContext().setAttribute("imageRoot", imageRoot);
        getServletContext().setAttribute("cssRoot", cssRoot);
        getServletContext().setAttribute("jsRoot", jsRoot);
        getServletContext().setAttribute("toolRoot", toolRoot);
        getServletContext().setAttribute("ssoRoot", ssoRoot);
        getServletContext().setAttribute("fileRoot", fileRoot);
        getServletContext().setAttribute("uploadRoot", uploadRoot);
        LOG.info("finish loading system resources");
    }

  
    @Override
    public void setServletContext(ServletContext servletContext) {
        application = servletContext;
    }

    public ServletContext getServletContext() {
        return this.application;
    }


    public String getWebRoot() {
        return webRoot;
    }


    public void setWebRoot(String webRoot) {
        this.webRoot = webRoot;
    }


    public String getImageRoot() {
        return imageRoot;
    }


    public void setImageRoot(String imageRoot) {
        this.imageRoot = imageRoot;
    }


    public String getCssRoot() {
        return cssRoot;
    }


    public void setCssRoot(String cssRoot) {
        this.cssRoot = cssRoot;
    }


    public String getJsRoot() {
        return jsRoot;
    }


    public void setJsRoot(String jsRoot) {
        this.jsRoot = jsRoot;
    }



    public String getToolRoot() {
        return toolRoot;
    }


    public void setToolRoot(String toolRoot) {
        this.toolRoot = toolRoot;
    }


    public String getSsoRoot() {
        return ssoRoot;
    }


    public void setSsoRoot(String ssoRoot) {
        this.ssoRoot = ssoRoot;
    }


    public String getFileRoot() {
        return fileRoot;
    }


    public void setFileRoot(String fileRoot) {
        this.fileRoot = fileRoot;
    }


    public String getUploadRoot() {
        return uploadRoot;
    }


    public void setUploadRoot(String uploadRoot) {
        this.uploadRoot = uploadRoot;
    }
}
