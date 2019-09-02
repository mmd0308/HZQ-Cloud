package com.hzqing.system.api.dto.menu;

import com.hzqing.system.api.constants.UserRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;

/**
 * @author hzqing
 * @date 2019-08-10 00:35
 */
@Data
public class AddMenuRequest extends AbstractRequest {

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 服务id
     */
    private String serveId;

    /**
     * 上级菜单id 顶级菜单父级id为0
     */
    private String parentId;

    /**
     * 所有父级id,用“,”顺序分隔
     */
    private String parentIds;

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
     * 删除标记 0 否 1是
     */
    private String delFlag;

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
        if (name == null || "".equals(name) || serveId == null || serveId.equals("")|| permission == null || permission.equals("")){
            throw new ParamsValidateException(
                    UserRetCodeConstants.INVALID_PARAMETER.getCode(),
                    UserRetCodeConstants.INVALID_PARAMETER.getMsg());
        }

    }
}
