package com.hzqing.system.rest.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.role.*;
import com.hzqing.system.api.service.IRoleService;
import com.hzqing.system.rest.converter.RoleConverter;
import com.hzqing.system.rest.vo.ResourceVo;
import com.hzqing.system.rest.vo.RoleTreeVO;
import com.hzqing.system.rest.vo.RoleVO;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(value = "根据条件获取树型角色结构")
    @GetMapping("/tree")
    public RestResult<List<RoleTreeVO>> tree(RoleVO roleVO){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RoleTreeRequest request = roleConverter.vo2TreeDto(roleVO);
        CommonResponse<List<RoleTreeDto>> response = roleService.tree(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            List<RoleTreeVO> res = roleConverter.dto2Treevo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "角色绑定资源")
    @PostMapping("/resource")
    public RestResult createResource(@RequestBody ResourceVo resourceVo){
        AddRoleResourceRequest request = roleConverter.resourceVo2Dto(resourceVo);
        CommonResponse response = roleService.saveResource(request);
        return result(response);
    }

    @ApiOperation(value = "角色绑定资源")
    @PutMapping("/resource")
    public RestResult updateBatchRoleResources(@RequestBody ResourceVo resourceVo){
        UpdateRoleResourceRequest request = roleConverter.resourceVo2UpdateDto(resourceVo);
        CommonResponse response = roleService.updateBatchResource(request);
        return result(response);
    }

    @ApiOperation(value = "根绝角色id，获取该角色的所有资源薪资")
    @GetMapping("/resource/{roleId}")
    public RestResult<List<ResourceVo>> listResource(@PathVariable String roleId){
        IDRequest request = new IDRequest(roleId);
        CommonResponse<List<RoleResourceDto>> response = roleService.listResource(request);
        return CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode()) ?
                RestResultFactory.getInstance().success(response.getData()) :
                RestResultFactory.getInstance().error();

    }
}
