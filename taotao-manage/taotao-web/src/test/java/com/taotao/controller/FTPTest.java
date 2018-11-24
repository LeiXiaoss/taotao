package com.taotao.controller;

import com.taotao.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FTPTest {

    @Test
    public void testFTPClient() throws Exception{
        FTPClient client = new FTPClient();
        client.connect("112.74.171.160",21);
        client.setControlEncoding("GBK");
        client.login("ftpuser","19960204lx");
        String replyString = client.getReplyString();
        System.out.println("replyString:"+replyString);

        FileInputStream stream = new FileInputStream(new File("/Users/leixiao/Downloads/qiuyi.jpg"));
        client.changeWorkingDirectory("/home/ftpuser/www/image");
        client.enterLocalPassiveMode();
        client.setFileType(FTP.BINARY_FILE_TYPE);
        if(client.storeFile("1.jpg",stream)){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
        client.logout();
    }

    @Test
    public void teatFTPUtils() throws Exception{
        FileInputStream inputStream = new FileInputStream(new File("/Users/leixiao/Downloads/qiuyi.jpg"));
        FtpUtil.uploadFile("112.74.171.160",21,"ftpuser","19960204lx","/home/ftpuser/www/image",
                "/2018/11/24","hello.jpg",inputStream);
    }
}
