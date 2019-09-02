package com.hzqing.system.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import com.hzqing.system.api.dto.button.*;

import java.util.List;

/**
 * <p>
 * 按钮资源表 服务类
 * </p>
 *
 * @author hzqing
 * @since 2019-08-13
 */
public interface IElementService {
    /**
     * 创建按钮
     * @param request
     * @return
     */
    CommonResponse save(AddElementRequest request);

    /**
     * 根据id获取按钮的信息
     * @param request
     * @return
     */
    CommonResponse<ElementDto> getById(IDRequest request);


    /**
     * 根据条件获取按钮列表
     * @param request
     * @return
     */
    CommonResponse<List<ElementDto>> list(ElementListRequest request);

    /**
     * 根据id删除按钮
     * @param request
     * @return
     */
    CommonResponse removeById(IDRequest request);

    /**
     * 根据id，更新按钮
     * @param request
     * @return
     */
    CommonResponse updateById(UpdateElementRequest request);

    /**
     * 分页查询按钮信息
     * @param request
     * @return
     */
    CommonResponse<Page<ElementDto>> page(ElementPageRequest request);
}
