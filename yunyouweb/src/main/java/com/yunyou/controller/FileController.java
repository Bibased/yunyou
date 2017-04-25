package com.yunyou.controller;

import com.yunyou.service.FileService;
import com.yunyou.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by lds on 2017/4/17.
 */
@Controller
public class FileController {
    @Resource
    FileService fileService;
    @RequestMapping("img/upload")
    @ResponseBody
    public String imgUpload(MultipartFile file, HttpSession session) throws IOException {
       return fileService.dealUploadImg(file, SessionUtil.getUserId(session));
    }
}
