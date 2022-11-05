package com.unicorn.controller;

import com.unicorn.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;


@RestController
@Slf4j
@RequestMapping("/common")
public class CommonController {

    @Value("${smart-store.path}")
    private String basePath;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = UUID.randomUUID().toString()+substring;

        File dir = new File(basePath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        try {
            file.transferTo(new File(basePath+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(filename);
    }


    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) throws Exception{

        //获取文件,从本地读取文件，所以用的是fileinput
        FileInputStream fileInputStream = new FileInputStream(new File(basePath+name));
        //输出文件。从网络输出数据，所以使用httpsevletresponse
        ServletOutputStream outputStream = response.getOutputStream();

        response.setContentType("image/jpeg");
        int len = 0 ;
        byte[] bytes = new byte[1024];


        while ((len = fileInputStream.read(bytes))!= -1) {
            outputStream.write(bytes);
            outputStream.flush();
        }

        outputStream.close();
        fileInputStream.close();


    }




}
