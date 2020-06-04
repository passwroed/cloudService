package cn.passwored.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "ums_admin")
public class UmsAdmin implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "`password`")
    private String password;

    @Column(name = "icon")
    private String icon;

    @Column(name = "email")
    private String email;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "note")
    private String note;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "`status`")
    private Integer status;

    private static final long serialVersionUID = 1L;
}