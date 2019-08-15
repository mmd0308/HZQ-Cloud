package com.hzqing.base.provider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.menu.*;
import com.hzqing.base.api.service.IMenuService;
import com.hzqing.base.provider.converter.MenuConverter;
import com.hzqing.base.provider.dal.entity.Menu;
import com.hzqing.base.provider.dal.mapper.MenuMapper;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.service.exception.ExceptionProcessUtils;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import com.hzqing.common.tools.tree.TreeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

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
            int row = menuMapper.updateById(menuConverter.req2Menu(request));
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
}
