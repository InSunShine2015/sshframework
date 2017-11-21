package com.jesus.sshframework.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jesus.sshframework.constant.SysConstant;
import com.jesus.sshframework.model.User;
import com.jesus.sshframework.service.IDataRecordService;
import com.jesus.sshframework.util.ImportExcelUtil;
import com.jesus.sshframework.vo.ChannelListQueryVo;
import com.jesus.sshframework.vo.Pager;





@Controller
@RequestMapping("/uploadExcel/*")
public class UploadExcelController {
    
    private static final Logger LOG = LoggerFactory.getLogger(UploadExcelController.class);
    @Resource
    private IDataRecordService dataRecordService;

    
    @RequestMapping(value="toUpload.do",method={RequestMethod.GET}) 
    public String toUploadExcel(HttpServletRequest request){
        return "upload";
    }
    /**  
     * 描述：通过传统方式form表单提交方式导入excel文件  
     * @param request  
     * @throws Exception  
     */  
    @RequestMapping(value="upload.do",method={RequestMethod.GET,RequestMethod.POST})  
    public  String  uploadExcel(HttpServletRequest request) throws Exception {  
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;    
        LOG.info("通过传统方式form表单提交方式导入excel文件！");  
          
        InputStream in =null;  
        List<List<String>> listob = null;  
        MultipartFile file = multipartRequest.getFile("upfile");  
        if(file.isEmpty()){  
            throw new Exception("文件不存在！");  
        }  
        in = file.getInputStream();  
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename()); 
        LOG.info("----->保存form表单上传解析结果");
        dataRecordService.saveUploadFileResult(listob);
        LOG.info("=============解析内容============");
        LOG.info(JSON.toJSONString(listob));
        in.close();  
          
        return "result";  
    }  
      
    /** 
     * 描述：通过 jquery.form.js 插件提供的ajax方式上传文件 
     * @param request 
     * @param response 
     * @throws Exception 
     */  
    @ResponseBody  
    @RequestMapping(value="ajaxUpload.do",method={RequestMethod.GET,RequestMethod.POST})  
    public  void  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {  
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;    
          
        LOG.info("通过 jquery.form.js 提供的ajax方式上传文件！");  
          
        InputStream in =null;  
        List<List<String>> listob = null;  
        MultipartFile file = multipartRequest.getFile("upfile");  
        if(file.isEmpty()){  
            throw new Exception("文件不存在！");  
        }  
          
        in = file.getInputStream();  
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        LOG.info("----->保存ajax上传解析结果");
        dataRecordService.saveUploadFileResult(listob);

        LOG.info("=============解析内容============");
        LOG.info(JSON.toJSONString(listob));  

          
        PrintWriter out = null;  
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码  
        out = response.getWriter();  
        out.print("文件导入成功！");  
        out.flush();  
        out.close();  
    } 
    @RequestMapping(value="toQueryChannel.do")
    public ModelAndView toQueryChannel(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("value1", "testvalue");
        mv.setViewName("list");
        return mv;
    }
    
    @ResponseBody
    @RequestMapping(value="queryChannel.do",method = {RequestMethod.POST})
    public void queryChannel(@RequestParam String pageNum,
                            @RequestParam String channel,
                            @RequestParam String startDate,
                            @RequestParam String endDate,
                            HttpServletResponse response,
                            HttpServletRequest request,
                            ModelAndView mv) throws IOException{
        ChannelListQueryVo vo = new ChannelListQueryVo();
        vo.setPageNum(pageNum);
        vo.setChannel(channel);
        vo.setStartDate(startDate);
        vo.setEndDate(endDate);
        User user = (User) request.getSession().getAttribute(SysConstant.SESSION_USER);
        if("common".equals(user.getUserType())){
            vo.setChannel(user.getChannel());
        }
        Pager page = dataRecordService.findChannel(vo);
        LOG.info(JSON.toJSONString(page));
        
        mv.addObject("queryResult", page.getList());
        mv.addObject("values", "rraeeee");
        PrintWriter out = null;  
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码  
        out = response.getWriter();  
        out.print(JSON.toJSONString(page));  
        out.flush();  
        out.close();  
        
    }
}
