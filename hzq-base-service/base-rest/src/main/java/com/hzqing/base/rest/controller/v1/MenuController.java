package com.hzqing.base.rest.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.menu.*;
import com.hzqing.base.api.service.IMenuService;
import com.hzqing.base.rest.converter.MenuConverter;
import com.hzqing.base.rest.vo.MenuTreeVO;
import com.hzqing.base.rest.vo.MenuVO;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.rest.controller.BaseController;
import com.hzqing.common.core.rest.result.RestResult;
import com.hzqing.common.core.rest.result.RestResultFactory;
import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-11 12:12
 */
@Api(tags = "菜单管理模块")
@Slf4j
@RestController
@RequestMapping("/base/" + GlobalConstants.VERSION_V1 + "/menus")
public class MenuController extends BaseController {

    @Reference(version = GlobalConstants.VERSION_V1)
    IMenuService menuService;

    @Autowired
    MenuConverter menuConverter;

    @ApiOperation(value = "根据id获取菜单")
    @GetMapping("/{id}")
    public RestResult<MenuVO> get(@PathVariable String id) {
        CommonResponse<MenuDto> response = menuService.getById(new IDRequest(id));
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            MenuVO res = menuConverter.dto2vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "菜单分页查询")
    @GetMapping("/page/{num}/{size}")
    public RestResult<Page<MenuVO>> page(@PathVariable int num,@PathVariable int size,MenuVO menuVO) {
        CommonResponse<Page<MenuDto>> response = menuService.page(new MenuPageRequest(num,size));
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())) {
            Page<MenuVO> res = menuConverter.pageDto2PageVo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "创建菜单")
    @PostMapping
    public RestResult create(@RequestBody MenuVO menuVO){
        log.info("MenuController.create request: " + menuVO);
        AddMenuRequest request = menuConverter.vo2Dto(menuVO);
        CommonResponse response = menuService.save(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，更新菜单")
    @PutMapping("/{id}")
    public RestResult update(@PathVariable String id, @RequestBody MenuVO menuVO) {
        log.info("MenuController.update request: " + menuVO);
        UpdateMenuRequest request = menuConverter.vo2UpdateDto(menuVO);
        CommonResponse response = menuService.updateById(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，删除菜单")
    @DeleteMapping("/{id}")
    public RestResult deleted(@PathVariable String id){
        CommonResponse response = menuService.removeById(new IDRequest(id));
        return result(response);
    }

    @ApiOperation(value = "根据条件，获取所有的菜单")
    @GetMapping
    public RestResult<MenuVO> list(MenuVO menuVO) {
        MenuListRequest request = menuConverter.vo2ListDto(menuVO);
        CommonResponse<List<MenuDto>> response = menuService.list(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            List<MenuVO> res = menuConverter.dto2vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }
    @ApiOperation(value = "根据条件获取树型菜单结构")
    @GetMapping("/tree")
    public RestResult<List<MenuTreeVO>> tree(MenuVO menuVO){
        MenuTreeRequest request = menuConverter.vo2TreeDto(menuVO);
        CommonResponse<List<MenuTreeDto>> response = menuService.tree(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            List<MenuTreeVO> res = menuConverter.dto2Treevo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }
}
