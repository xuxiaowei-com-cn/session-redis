package cn.com.xuxiaowei.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static cn.com.xuxiaowei.utils.Constants.DEFAULT_DATE_TIME_FORMAT;

/**
 * 用户类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime createDateTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = DEFAULT_DATE_TIME_FORMAT)
    private LocalDateTime updateDateTime;

}
