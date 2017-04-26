package com.yunyou.service;

import com.yunyou.common.util.DataConvertUtil;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by lds on 2017/4/18.
 */
@Service
public class FileService {
    @Value("${upload.file.home}")
    String fileDir ;
    double maxSize = 80.0 * 1000;
    public String dealUploadImg(MultipartFile file,Long id){
        // 包含原始文件名的字符串
        String originName = file.getOriginalFilename();
        // 提取文件拓展名
        String fileNameExtension = originName.substring(originName.indexOf("."), originName.length());
        // 生成实际存储的真实文件名
        String fileName = UUID.randomUUID().toString()+fileNameExtension;
        File parent = new File(fileDir+"img/"+id);
        if (!parent.exists()) parent.mkdirs();
        try {
            double radio = 1;
            if (file.getSize() > maxSize)
                radio = Math.sqrt(maxSize / file.getSize());
            Thumbnails.of(file.getInputStream()).scale(radio).toFile(new File(parent,fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回图片的URL地址
        return  "/static/img/"+id+"/"+fileName;
    }
    public String dealUploadImg(List<MultipartFile> files,Long id){
        if (null==files) return null;
        return files.stream()
                .filter(file -> !StringUtils.isEmpty(file.getName()))
                .reduce("",(str, file)->str+dealUploadImg(file,id)+ DataConvertUtil.BORDER_CHAR,(a, b)->a+b);
    }
}
