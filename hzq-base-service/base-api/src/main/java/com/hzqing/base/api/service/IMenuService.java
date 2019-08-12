package com.hzqing.base.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.menu.*;
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
    CommonResponse createMenu(AddMenuRequest request);

    /**
     * 获取菜单列表
     * @param request
     * @return
     */
    CommonResponse<List<MenuDto>> menuLists(MenuListRequest request);

    /**
     * 根据条件删除菜单
     * @param request
     * @return
     */
    CommonResponse deleteMenu(DeleteMenuRequest request);

    /**
     * 根据条件更新菜单
     * @param request
     * @return
     */
    CommonResponse updateMenu(UpdateMenuRequest request);

    /**
     * 根据条件，返回菜单详情
     * @param request
     * @return
     */
    CommonResponse<MenuDto> menuDetail(MenuDetailRequest request);

    /**
     * 分页条件查询
     * @param request
     * @return
     */
    CommonResponse<Page<MenuDto>> menuPage(MenuPageRequest request);
}
