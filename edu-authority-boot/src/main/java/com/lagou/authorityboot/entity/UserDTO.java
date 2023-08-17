package com.lagou.eduauthorityboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-02-24 21:28
 * @Description:数据传输对象（DTO) Data Transfer Object
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO<User> implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 操作状态
     *
     */
    private Integer state;
    /**
     *  状态描述
     */
    private String message;
    /**响应内容
     *
     */
    private User content;
    /**令牌
     *
     */
    private String token;
}