package com.hzqing.system.api.dto.role;

import com.hzqing.system.api.constants.UserRetCodeConstants;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-10 00:35
 */
@Data
public class AddRoleRequest extends AbstractRequest {

    private String id;

    private String parentId;

    private String parentIds;


    /**
     * 数据值
     */
    private String name;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记删除标记 ‘0’ 没有删除, ‘1’ 删除
     */
    private String delFlag;

    /**
     * 系统角色标记 ‘0’ 不是 ‘1’是
     */
    private String sysFlag;

    /**
     * 创建人id
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人id
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 请求参数进行校验
     */
    @Override
    public void checkParams() {
        if (name == null || "".equals(name)){
            throw new ParamsValidateException(
                    UserRetCodeConstants.INVALID_PARAMETER.getCode(),
                    UserRetCodeConstants.INVALID_PARAMETER.getMsg());
        }
    }
}
