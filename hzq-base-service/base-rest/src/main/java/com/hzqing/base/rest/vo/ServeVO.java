package com.hzqing.base.rest.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hzqing
 * @date 2019-08-13 21:33
 */
@Data
public class ServeVO implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 服务名称
     */
    private String name;

    /**
     * 服务状态
     */
    private String status;
}
