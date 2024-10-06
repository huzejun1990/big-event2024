package com.dream.controller;

import com.dream.pojo.Result;
import com.dream.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Auther: huzejun
 * @Date: 2024/10/6 18:16
 */
@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        //把文件的内容存储到本地磁盘上
        String originalFilename = file.getOriginalFilename();
        //保证文件的名字是唯一的，从而保证防止文件覆盖
        String fileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //本地存储
        //        file.transferTo(new File("E:\\files\\"+fileName));
        String url = AliOssUtil.uploadFile(fileName, file.getInputStream());
//        return Result.success("url访问地址...");
        return Result.success(url);
    }


}
