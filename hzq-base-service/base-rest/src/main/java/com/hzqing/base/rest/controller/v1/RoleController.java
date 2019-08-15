package com.hzqing.base.rest.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.role.*;
import com.hzqing.base.api.service.IRoleService;
import com.hzqing.base.rest.converter.RoleConverter;
import com.hzqing.base.rest.vo.RoleVO;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.rest.controller.BaseController;
import com.hzqing.common.core.rest.result.RestResult;
import com.hzqing.common.core.rest.result.RestResultFactory;
import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.request.IDRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色管理模块
 * @author hzqing
 * @date 2019-08-11 12:12
 */
@Api(tags = "角色管理模块")
@RestController
@RequestMapping("/base/" + GlobalConstants.VERSION_V1 + "/roles")
public class RoleController extends BaseController {


    @Reference(version = GlobalConstants.VERSION_V1)
    IRoleService roleService;

    @Autowired
    RoleConverter roleConverter;

    @ApiOperation(value = "根据id获取菜单")
    @GetMapping("/{id}")
    public RestResult<RoleVO> get(@PathVariable String id) {
        CommonResponse<RoleDto> response = roleService.getById(new IDRequest(id));
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            RoleVO res = roleConverter.dto2vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "角色分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页展示数量", required = true, paramType = "path", dataType = "int")
    })
    @GetMapping("/page/{num}/{size}")
    public RestResult<Page<RoleVO>> page(@PathVariable int num, @PathVariable int size, RoleVO roleVO){
        RolePageRequest request = new RolePageRequest();
        request.setPageNum(num);
        request.setPageSize(size);
        CommonResponse<Page<RoleDto>> response = roleService.page(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            Page<RoleVO> res = roleConverter.dto2Vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }
    @ApiOperation(value = "创建角色")
    @PostMapping
    public RestResult create(@RequestBody RoleVO RoleVO){
        AddRoleRequest request = roleConverter.vo2Dto(RoleVO);
        CommonResponse response = roleService.save(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，更新角色")
    @PutMapping("/{id}")
    public RestResult update(@PathVariable String id, @RequestBody RoleVO RoleVO) {
        UpdateRoleRequest request = roleConverter.vo2UpdateDto(RoleVO);
        CommonResponse response = roleService.updateById(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，删除删除")
    @DeleteMapping("/{id}")
    public RestResult deleted(@PathVariable String id){
        CommonResponse response = roleService.removeById(new IDRequest(id));
        return result(response);
    }
}
