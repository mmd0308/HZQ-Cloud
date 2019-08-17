package com.hzqing.base.rest.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hzqing
 * @date 2019-08-17 09:41
 */
@Data
public class ResourceVo implements Serializable {

    private static final long serialVersionUID = -4899751407038945680L;


    private String roleId;

    private String serveId;

    private String menuId;

    private String elementId;

}
