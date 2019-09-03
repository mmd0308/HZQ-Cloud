package com.hzqing.system.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.service.request.PermissionRequest;
import com.hzqing.system.api.dto.menu.*;
import com.hzqing.system.api.service.IMenuService;
import com.hzqing.system.provider.converter.MenuConverter;
import com.hzqing.system.provider.dal.entity.Menu;
import com.hzqing.system.provider.dal.entity.Serve;
import com.hzqing.system.provider.dal.mapper.MenuMapper;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.service.exception.ExceptionProcessUtils;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import com.hzqing.common.core.tree.TreeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author hengzhaoqing
 * @since 2019-08-09
 */
@Slf4j
@Service(version = GlobalConstants.VERSION_V1)
public class MenuServiceImpl  implements IMenuService {

    private final static String PARENT_ID = "0";

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuConverter menuConverter;

    @Override
    public CommonResponse save(AddMenuRequest request) {
        log.info("MenuServiceImpl.save request: " + request);
        CommonResponse response = new CommonResponse();
        try {
            request.checkParams();
            Menu menu = menuConverter.req2Menu(request);
            menu.setCreateTime(LocalDateTime.now());
            menu.setUpdateTime(LocalDateTime.now());
            int row = menuMapper.insert(menu);
            log.info("MenuServiceImpl.createMenu effect row: " + row);
        }catch (Exception e){
            log.error("MenuServiceImpl.createMenu occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<List<MenuDto>> list(MenuListRequest request) {
        CommonResponse<List<MenuDto>> response = new CommonResponse<>();
        try {
            Menu menu = menuConverter.req2Menu(request);
            List<Menu> menus = menuMapper.selectList(new QueryWrapper<>(menu));
            response.setData(menuConverter.listMenu2ListDto(menus));
        }catch (Exception e){
            log.error("MenuServiceImpl.menuLists occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse removeById(IDRequest request) {
        CommonResponse response = new CommonResponse();
        log.info("MenuServiceImpl.deleteMenu request: " + request);
        try {
            int row = menuMapper.deleteById(request.getId());
            log.info("MenuServiceImpl.deleteMenu effect row: " + row);
        }catch (Exception e){
            log.error("MenuServiceImpl.deleteMenu occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse updateById(UpdateMenuRequest request) {
        CommonResponse response = new CommonResponse();
        log.info("MenuServiceImpl.updateMenu request: " + request);
        try{
            request.checkParams();
            Menu menu = menuConverter.req2Menu(request);
            menu.setUpdateTime(LocalDateTime.now());
            int row = menuMapper.updateById(menu);
        }catch (Exception e) {
            log.error("MenuServiceImpl.updateMenu occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<MenuDto> getById(IDRequest request) {
        log.info("MenuServiceImpl.menuDetail request: " + request);
        CommonResponse<MenuDto> response = new CommonResponse<>();
        try {
            request.checkParams();
            Menu menu = menuMapper.selectById(request.getId());
            response.setData(menuConverter.req2Dto(menu));
        } catch (Exception e){
            log.error("MenuServiceImpl.menuDetail occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<Page<MenuDto>> page(MenuPageRequest request) {
        log.info("MenuServiceImpl.menuPage request: " + request);
        CommonResponse<Page<MenuDto>> response = new CommonResponse<>();
        try {
            request.checkParams();
            Menu menu = menuConverter.req2Menu(request);
            IPage<Menu> menuIPage = menuMapper.selectPage(new Page<Menu>(request.getPageNum(),
                    request.getPageSize()), new QueryWrapper<Menu>(menu));
            response.setData(menuConverter.pageMenu2PageDto(menuIPage));
            log.info("MenuServiceImpl.menuPage result: " + response);
        }catch (Exception e) {
            log.error("MenuServiceImpl.menuPage occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<List<MenuTreeDto>> tree(MenuTreeRequest request) {
        log.info("MenuServiceImpl.tree request: " + request);
        CommonResponse<List<MenuTreeDto>> response = new CommonResponse<>();
        try {
            request.checkParams();
            Menu menu = menuConverter.req2Menu(request);
            List<Menu> menus = menuMapper.selectList(new QueryWrapper<>(menu));
            List<MenuTreeDto> listDtos = menuConverter.listMenu2ListTreeDto(menus);
            log.info("MenuServiceImpl.tree 组装属性结果，查询数据数量是： " + listDtos.size());
            List<MenuTreeDto> treeDtos = TreeUtils.buildTree(PARENT_ID, listDtos);
            response.setData(treeDtos);
        } catch (Exception e) {
            log.error("MenuServiceImpl.tree occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public CommonResponse<Boolean> checkPermission(PermissionRequest request) {
        log.info("MenuServiceImpl.checkPermission request: " + request);
        CommonResponse<Boolean> response = new CommonResponse<>();
        boolean res = false;
        try {
            request.checkParams();
            Menu menu = new Menu();
            menu.setPermission(request.getPermission());
            List<Menu> menus = menuMapper.selectList(new QueryWrapper<>(menu));
            log.info("MenuServiceImpl.checkPermission 查询结果集：" + menus);
            res = menus.size() == 0;
            if (menus.size() == 1) {
                Menu ser = menus.get(0);
                if (StringUtils.isNotEmpty(request.getId())) {
                    // 表示修改，权限编码是自己
                    res = ser.getId().equals(request.getId());
                }
            }
            response.setData(res);
        } catch (Exception e) {
            log.error("MenuServiceImpl.checkPermission occur Exception: ", e);
            ExceptionProcessUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
