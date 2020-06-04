package cn.passwored.business;

/**
 * @program: cloudService
 * @description: 全局业务异常
 * @author: WangKe
 * @create: 2020-06-04 11:19
 **/
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = -1337409457287303159L;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException() {

    }

    public BusinessException(BusinessStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
    }
}
