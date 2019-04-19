package com.bupt.qingzaoreading.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;

import java.net.URL;
import java.util.Date;

public class FilePath {


    //  oos   相关   数据
    public static final String endpoint="http://oss-cn-beijing.aliyuncs.com/";
    public static final  String accessKeyId = "LTAINIcvCcsIqETW";
    public static final  String accessKeySecret = "Uk6OmZ0MY1Q1t89OFP4JrK1AzyY6Yt";
    public static final String bucketName="szpstore";
    public static final String accessUrl="http://szpstore.oss-cn-beijing.aliyuncs.com";
    //  oos   相关   结束

    public static String getUrl(String key){

        OSSClient ossClient = new OSSClient(FilePath.endpoint, FilePath.accessKeyId,
                FilePath.accessKeySecret);
        // 设置URL过期时间为1小时
        Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        GeneratePresignedUrlRequest generatePresignedUrlRequest ;
        generatePresignedUrlRequest =new GeneratePresignedUrlRequest(FilePath.bucketName, key);
        generatePresignedUrlRequest.setExpiration(expiration);
        URL url = ossClient.generatePresignedUrl(generatePresignedUrlRequest);
        ossClient.shutdown();
        return url.toString();
    }
}

