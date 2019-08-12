package com.hzqing.base.rest.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.menu.*;
import com.hzqing.base.api.dto.role.*;
import com.hzqing.base.api.service.IRoleService;
import com.hzqing.base.rest.converter.RoleConverter;
import com.hzqing.base.rest.vo.RoleVO;
import com.hzqing.base.rest.vo.RoleVO;
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
 * 角色管理模块
 * @author hzqing
 * @date 2019-08-11 12:12
 */
@Api(tags = "角色管理模块")
@RestController
@RequestMapping("/" + GlobalConstants.VERSION_V1 + "/roles")
public class RoleController extends BaseController {


    @Reference(version = GlobalConstants.VERSION_V1)
    IRoleService roleService;

    @Autowired
    RoleConverter roleConverter;

    @ApiOperation(value = "根据id获取菜单")
    @GetMapping("/{id}")
    public RestResult<RoleVO> get(@PathVariable int id) {
        RoleDetailRequest request = new RoleDetailRequest();
        request.setId(id);
        CommonResponse<RoleDto> response = roleService.roleDetail(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            RoleVO res = roleConverter.dto2vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }


    @ApiOperation(value = "创建角色")
    @PostMapping
    public RestResult create(@RequestBody RoleVO RoleVO){
        AddRoleRequest request = roleConverter.vo2Dto(RoleVO);
        CommonResponse response = roleService.createRole(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，更新角色")
    @PutMapping("/{id}")
    public RestResult update(@PathVariable int id, @RequestBody RoleVO RoleVO) {
        UpdateRoleRequest request = roleConverter.vo2UpdateDto(RoleVO);
        CommonResponse response = roleService.updateRole(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，删除删除")
    @DeleteMapping("/{id}")
    public RestResult deleted(@PathVariable int id){
        DeleteRoleRequest request = new DeleteRoleRequest();
        request.setId(id);
        CommonResponse response = roleService.deleteRole(request);
        return result(response);
    }
}
