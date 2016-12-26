package com.aiyun.utils;

import com.aiyun.utils.bean.FileInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhaoy on 2016/12/6.
 */
public class ImageUploadUtil {

    public static List<FileInfo> upload(HttpServletRequest request, String DirectoryName) throws IllegalStateException,
        IOException {
        List<FileInfo> fileInfoList = new ArrayList<>();  //list of upload files
        FileInfo fileInfo;  //single file info
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
            .getServletContext());
        String fileName = null;
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                fileInfo = new FileInfo();
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    String myFileName = file.getOriginalFilename();
                    if (StringUtils.isNotEmpty(myFileName.trim())) {
                        myFileName = new String(myFileName.getBytes("ISO-8859-1"), "utf-8");
                        myFileName = myFileName.substring(0,myFileName.lastIndexOf("."));
                        String originalFilename = file.getOriginalFilename();
                        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
                        File realPathDirectory = new File(DirectoryName);
                        if (realPathDirectory == null || !realPathDirectory.exists()) {
                            realPathDirectory.mkdirs();
                        }
                        fileName = RandomUtil.generatePassword() + suffix;
                        File uploadFile = new File(realPathDirectory + "/" + fileName);
                        fileInfo.setFileName(myFileName);
                        fileInfo.setPath(fileName);
                        fileInfoList.add(fileInfo);
                        file.transferTo(uploadFile);
                    }
                }
            }
        }
        return fileInfoList;
    }
}

