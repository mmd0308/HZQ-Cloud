package com.hzqing.base.api.dto.serve;

import com.hzqing.common.core.service.request.IDRequest;
import lombok.Data;
import lombok.ToString;

/**
 * @author hzqing
 * @date 2019-08-12 23:03
 */
@Data
@ToString(callSuper = true)
public class UpdateServeRequest extends IDRequest {

    /**
     * 服务名称
     */
    private String name;

    /**
     * 服务状态
     */
    private String status;


    @Override
    public void checkParams() {
        super.checkParams();
    }
}
