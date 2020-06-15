package cn.passwored.cloud.feign.fallback;

import cn.passwored.cloud.dto.FileInfo;
import cn.passwored.cloud.feign.UploadFeign;
import cn.passwored.commons.dto.ResponseResult;
import cn.passwored.commons.utils.MapperUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: cloudService
 * @description: 文件上传熔断器
 * @author: WangKe
 * @create: 2020-06-13 14:51
 **/
@Component
public class UploadFeignFallback implements UploadFeign {
    private static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";

    @Override
    public String upload(MultipartFile multipartFile) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String fileUpload(MultipartFile multipartFile) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(ResponseResult.CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
