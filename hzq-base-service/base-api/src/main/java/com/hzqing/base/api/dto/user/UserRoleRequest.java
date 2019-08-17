package com.hzqing.base.api.dto.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.dal.BaseEntity;
import com.hzqing.common.core.service.exception.ParamsValidateException;
import com.hzqing.common.core.service.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserRoleDto extends AbstractRequest {

    /**
     * 主键
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;


    @Override
    public void checkParams() {
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(roleId)){
            throw new ParamsValidateException(
                    CommonRetCodeConstants.INVALID_PARAMETER.getCode(),
                    "绑定用户和角色关系，用户id和角色id都不能唯空！"
            );
        }
    }
}
