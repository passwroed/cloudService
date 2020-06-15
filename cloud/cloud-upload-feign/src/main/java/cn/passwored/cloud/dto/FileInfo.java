package cn.passwored.cloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: cloudService
 * @description: 文件信息
 * @author: WangKe
 * @create: 2020-06-13 14:55
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileInfo implements Serializable {
    private static final long serialVersionUID = -4742534536760119269L;
    /**
     * 文件路径
     */
    private String path;
}
