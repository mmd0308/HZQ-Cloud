package com.hzqing.base.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.serve.*;
import com.hzqing.common.core.service.response.CommonResponse;

import java.util.List;

/**
 * <p>
 * 服务管理表 服务类
 * </p>
 *
 * @author hzqing
 * @since 2019-08-13
 */
public interface IServeService {
    /**
     * 创建服务
     * @param request
     * @return
     */
    CommonResponse createServe(AddServeRequest request);

    /**
     * 根据条件获取服务的信息
     * @param request
     * @return
     */
    CommonResponse<ServeDto> serveDetail(ServeDetailRequest request);


    /**
     * 根据条件获取服务列表
     * @param request
     * @return
     */
    CommonResponse<List<ServeDto>> serveLists(ServeListRequest request);

    /**
     * 根据条件删除服务
     * @param request
     * @return
     */
    CommonResponse deleteServe(DeleteServeRequest request);

    /**
     * 根据id，更新服务
     * @param request
     * @return
     */
    CommonResponse updateServe(UpdateServeRequest request);

    /**
     * 分页查询服务信息
     * @param request
     * @return
     */
    CommonResponse<Page<ServeDto>> servePage(ServePageRequest request);
}
