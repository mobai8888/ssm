package com.sun.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @program: springMvc
 * @ClassName UploadController
 * @description:文件上传控制器
 * @author: lk
 * @create: 2020-03-31 20:05
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UploadController {
    //传统方式
    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request) throws Exception {
        System.out.println("文件传统上传");
        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file=new File(path);
        if(!file.exists()){
            //创建该文件夹
            file.mkdir();
        }
        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items= upload.parseRequest(request);
        //遍历
        for(FileItem item:items){
            // 进行判断，当前item对象是否是上传文件项
            if(item.isFormField()){
                //说明普通表单向
            }else{
                // 说明上传文件项
                String fileName=item.getName();
                // 获取上传文件的名称
                // 把文件的名称设置唯一值，uuid
                String uuid= UUID.randomUUID().toString().replace("-","");
                fileName=uuid+"_"+fileName;
                // 完成文件上传
                item.write(new File(path,fileName));
                // 删除临时文件
            }
        }
        return "success";
    }
    //springmvc方式
    @RequestMapping("/fileupload2")
  public String fileupload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("springmvc文件上传");
        // 使用fileupload组件完成文件上传
      // 上传的位置
      String path = request.getSession().getServletContext().getRealPath("/uploads/");
      // 判断，该路径是否存在
      File file = new File(path);
      if(!file.exists()){
          // 创建该文件夹
          file.mkdirs();
      }
      // 说明上传文件项
      // 获取上传文件的名称
      String filename = upload.getOriginalFilename();
      System.out.println("上传文件的名称:"+filename);
      //设置唯一值
      String uuid=UUID.randomUUID().toString().replace("-","");
      filename=uuid+"_"+filename;
      //完成文件上传
      upload.transferTo(new File(path,filename));
        return "success";
  }

    //分服务器
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws IOException {
        System.out.println("跨服务器文件上传....");
        //定义上传文件的服务器路径
        String path="http://localhost:8080//uploads/";
        //说明上传文件项
        //获取上传文件的名称
        String fileName=upload.getOriginalFilename();
        //设置文件唯一值
        String uuid=UUID.randomUUID().toString().replace("_","");
        fileName=uuid+"_"+fileName;
        //创建客户端的对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(path + fileName);
        //上传文件
        webResource.put(upload.getBytes());
        return "success";
    }
}
