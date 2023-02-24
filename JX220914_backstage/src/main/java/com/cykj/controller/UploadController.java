package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/image")
    public String uploadImage(MultipartFile file,HttpServletRequest res){
        CommonsMultipartFile files = (CommonsMultipartFile) file;
        // 获取路径
        String path = res.getSession().getServletContext().getRealPath("/WEB-INF/upload");
        // 判断文件夹是否存在
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        String[] strings = file.getOriginalFilename().split("\\.");
        String filename = new Date().getTime()+"."+strings[strings.length-1];
        try {
            file.transferTo(new File(realPath+"/"+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject js = new JSONObject();
        js.put("code",0);
        js.put("msg","");
        js.put("data","upload/"+filename);
        return js.toString();
    }
}
