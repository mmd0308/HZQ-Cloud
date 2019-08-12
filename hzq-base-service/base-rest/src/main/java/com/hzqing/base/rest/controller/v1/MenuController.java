package com.hzqing.base.rest.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.menu.*;
import com.hzqing.base.api.service.IMenuService;
import com.hzqing.base.rest.converter.MenuConverter;
import com.hzqing.base.rest.vo.MenuVO;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.rest.controller.BaseController;
import com.hzqing.common.core.rest.result.RestResult;
import com.hzqing.common.core.rest.result.RestResultFactory;
import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hzqing
 * @date 2019-08-11 12:12
 */
@Api(tags = "菜单管理模块")
@RestController
@RequestMapping("/" + GlobalConstants.VERSION_V1 + "/menus")
public class MenuController extends BaseController {

    @Reference(version = GlobalConstants.VERSION_V1)
    IMenuService menuService;

    @Autowired
    MenuConverter menuConverter;

    @ApiOperation(value = "根据id获取菜单")
    @GetMapping("/{id}")
    public RestResult<MenuVO> get(@PathVariable int id) {
        MenuDetailRequest request = new MenuDetailRequest();
        request.setId(id);
        CommonResponse<MenuDto> response = menuService.menuDetail(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            MenuVO res = menuConverter.dto2vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "菜单分页查询")
    @GetMapping("/page/{num}/{size}")
    public RestResult<Page<MenuVO>> page(@PathVariable int num,@PathVariable int size,MenuVO menuVO) {
        CommonResponse<Page<MenuDto>> response = menuService.menuPage(new MenuPageRequest(num,size));
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())) {
            Page<MenuVO> res = menuConverter.pageDto2PageVo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "创建菜单")
    @PostMapping
    public RestResult create(@RequestBody MenuVO menuVO){
        AddMenuRequest request = menuConverter.vo2Dto(menuVO);
        CommonResponse response = menuService.createMenu(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，更新菜单")
    @PutMapping("/{id}")
    public RestResult update(@PathVariable int id, @RequestBody MenuVO menuVO) {
        UpdateMenuRequest request = menuConverter.vo2UpdateDto(menuVO);
        CommonResponse response = menuService.updateMenu(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，删除菜单")
    @DeleteMapping("/{id}")
    public RestResult deleted(@PathVariable int id){
        DeleteMenuRequest request = new DeleteMenuRequest();
        request.setId(id);
        CommonResponse response = menuService.deleteMenu(request);
        return result(response);
    }
}
