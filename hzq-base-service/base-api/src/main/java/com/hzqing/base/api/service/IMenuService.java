package com.hzqing.base.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.menu.*;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
public interface IMenuService  {

    /**
     * 新增菜单
     * @param request
     * @return
     */
    CommonResponse save(AddMenuRequest request);

    /**
     * 获取菜单列表
     * @param request
     * @return
     */
    CommonResponse<List<MenuDto>> list(MenuListRequest request);

    /**
     * 根据id删除菜单
     * @param request
     * @return
     */
    CommonResponse removeById(IDRequest request);

    /**
     * 根据ID更新菜单
     * @param request
     * @return
     */
    CommonResponse updateById(UpdateMenuRequest request);

    /**
     * 根据id，返回菜单详情
     * @param request
     * @return
     */
    CommonResponse<MenuDto> getById(IDRequest request);

    /**
     * 分页条件查询
     * @param request
     * @return
     */
    CommonResponse<Page<MenuDto>> page(MenuPageRequest request);

    /**
     * 根据条件获取所有树行结果
     * @param request
     * @return
     */
    CommonResponse<List<MenuTreeDto>> tree(MenuTreeRequest request);

}
