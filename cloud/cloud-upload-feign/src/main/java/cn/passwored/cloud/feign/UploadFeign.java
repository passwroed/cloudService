package cn.passwored.cloud.feign;

import cn.passwored.cloud.dto.FileInfo;
import cn.passwored.cloud.feign.fallback.UploadFeignFallback;
import cn.passwored.commons.dto.ResponseResult;
import cn.passwored.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "cloud-upload", path = "upload", configuration = FeignRequestConfiguration.class, fallback = UploadFeignFallback.class)
public interface UploadFeign {

    /**
     * 文件上传
     *
     * @param multipartFile {@code MultipartFile}
     * @return {@code String} 文件上传路径
     */
    @PostMapping(value = "/oss")
    String upload(@RequestPart(value = "multipartFile") MultipartFile multipartFile);

    @PostMapping(value = "/imageFileUpload")
    String fileUpload(@RequestPart(value = "multipartFile") MultipartFile multipartFile);
}
