package com.hzqing.base.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.button.*;
import com.hzqing.common.core.service.response.CommonResponse;

import java.util.List;

/**
 * <p>
 * 按钮资源表 服务类
 * </p>
 *
 * @author hzqing
 * @since 2019-08-13
 */
public interface IButtonService {
    /**
     * 创建按钮
     * @param request
     * @return
     */
    CommonResponse createButton(AddButtonRequest request);

    /**
     * 根据条件获取按钮的信息
     * @param request
     * @return
     */
    CommonResponse<ButtonDto> buttonDetail(ButtonDetailRequest request);


    /**
     * 根据条件获取按钮列表
     * @param request
     * @return
     */
    CommonResponse<List<ButtonDto>> buttonLists(ButtonListRequest request);

    /**
     * 根据条件删除按钮
     * @param request
     * @return
     */
    CommonResponse deleteButton(DeleteButtonRequest request);

    /**
     * 根据id，更新按钮
     * @param request
     * @return
     */
    CommonResponse updateButton(UpdateButtonRequest request);

    /**
     * 分页查询按钮信息
     * @param request
     * @return
     */
    CommonResponse<Page<ButtonDto>> buttonPage(ButtonPageRequest request);
}
