package cn.passwored.cloud.controller;

import cn.passwored.cloud.dto.FileInfo;
import cn.passwored.commons.dto.ResponseResult;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: cloudService
 * @description: 文件上传服务
 * @author: WangKe
 * @create: 2020-06-13 14:59
 **/
@RestController
@RequestMapping(value = "/upload")
public class controller {
    private static final String ENDPOINT = ".aliyuncs.com";
    private static final String ACCESS_KEY_ID = "";
    private static final String ACCESS_KEY_SECRET = "";
    private static final String BUCKET_NAME = "javasite";
    private static final String BASEURL = "http://192.168.0.108/img/";
    /**
     * 文件上传
     * oss
     * @param multipartFile @{code MultipartFile}
     * @return {@link ResponseResult<FileInfo>} 文件上传路径
     */
    @PostMapping(value = "/oss")
    public ResponseResult<FileInfo> upload(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newName = UUID.randomUUID() + "." + suffix;

        OSS client = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        try {
            client.putObject(new PutObjectRequest(BUCKET_NAME, newName, new ByteArrayInputStream(multipartFile.getBytes())));
            // 上传文件路径 = http://BUCKET_NAME.ENDPOINT/自定义路径/fileName
            return new ResponseResult<FileInfo>(ResponseResult.CodeStatus.OK, "文件上传成功", new FileInfo("http://" + BUCKET_NAME + "." + ENDPOINT + "/" + newName));
        } catch (IOException e) {
            return new ResponseResult<FileInfo>(ResponseResult.CodeStatus.FAIL, "文件上传失败，请重试");
        } finally {
            client.shutdown();
        }
    }
    /**
     * 文件上传
     * 上传到内网
     * @param file
     * @return {@link ResponseResult<FileInfo>} 文件上传路径
     */
    @RequestMapping("/imageFileUpload")
    @ResponseBody
    public ResponseResult<FileInfo> fileUpload(MultipartFile file,HttpServletRequest request) throws IOException {
        // 判断用户是否登录
        // 判断上传的文件是否为空
        if (file != null) {

            // 文件路径
            String path = null;
            // 文件类型
            String type = null;
            // 文件原名称
            String fileName = file.getOriginalFilename();
            // 判断文件类型
            System.out.println("上传的文件原名称:" + fileName);
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            // 判断文件类型是否为空
            if (type != null) {

                if ("GIF".equals(type.toUpperCase()) || "JPEG".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = "/Users/wangke/保存网页/";
//                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + "."+type.toUpperCase();
                    // 设置存放图片文件的路径
                    path = realPath +trueFileName;
                    // 转存文件到指定的路径
                    System.out.println("存放图片文件的路径:" + path);
                    file.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");
                    return new ResponseResult<FileInfo>(ResponseResult.CodeStatus.OK, "文件上传成功", new FileInfo(BASEURL+trueFileName));
                } else {
                    return new ResponseResult<FileInfo>(ResponseResult.CodeStatus.FAIL, "不是我们想要的文件类型,请按要求重新上传");
                }
            } else {
                return new ResponseResult<FileInfo>(ResponseResult.CodeStatus.FAIL, "文件类型为空，请重试");
            }
        } else {
            return new ResponseResult<FileInfo>(ResponseResult.CodeStatus.FAIL, "没有找到相对应的文件，请重试");
        }
    }
}
