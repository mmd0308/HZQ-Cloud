package com.hzqing.system.api.dto.menu;

import com.hzqing.common.core.service.request.IDRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-10 00:35
 */
@Data
public class UpdateMenuRequest extends IDRequest {

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 服务id
     */
    private String serveId;

    /**
     * 链接
     */
    private String href;

    /**
     * 图标名称
     */
    private String icon;

    /**
     * 是否在菜单显示 0 否 1 是 默认是1
     */
    private String showFlag;

    /**
     * 权限标示
     */
    private String permission;


    /**
     * 备注信息
     */
    private String description;

    /**
     * 排序
     */
    private Integer sort;


    /**
     * 请求参数进行校验
     */
    @Override
    public void checkParams() {
        super.checkParams();
    }
}
