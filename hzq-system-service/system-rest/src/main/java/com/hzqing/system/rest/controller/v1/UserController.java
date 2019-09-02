package com.hzqing.system.rest.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.system.api.dto.user.*;
import com.hzqing.system.api.service.IUserService;
import com.hzqing.system.rest.converter.UserConverter;
import com.hzqing.system.rest.vo.UserVO;
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
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-11 09:54
 */
@Api(tags = "用户管理模块")
@Slf4j
@RestController
@RequestMapping("/"+ GlobalConstants.VERSION_V1 +"/users")
public class UserController extends BaseController {
    
    

    @Reference(version = GlobalConstants.VERSION_V1)
    private IUserService userService;

    @Autowired
    private UserConverter userConverter;

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/{id}")
    public RestResult<UserVO> get(@PathVariable String id){
        IDRequest request = new IDRequest();
        request.setId(id);
        CommonResponse<UserDto> response = userService.getById(request);
        if (response.getCode().equals(CommonRetCodeConstants.SUCCESS.getCode())){
            UserVO res = userConverter.dto2Vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "用户分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页展示数量", required = true, paramType = "path", dataType = "int")
    })
    @GetMapping("/page/{num}/{size}")
    public RestResult<Page<UserVO>> page(@PathVariable int num,
                                         @PathVariable int size,
                                         UserVO userVO){
        UserPageRequest request = new UserPageRequest();
        request.setPageNum(num);
        request.setPageSize(size);
        CommonResponse<Page<UserDto>> response = userService.page(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            Page<UserVO> res = userConverter.dto2Vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }


    @ApiOperation(value = "创建用户")
    @PostMapping
    public RestResult create(@RequestBody UserVO userVO){
        AddUserRequest request = userConverter.vo2Dto(userVO);
        CommonResponse response = userService.save(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            return RestResultFactory.getInstance().success();
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "根据id，更新用户")
    @PutMapping("/{id}")
    public RestResult update(@PathVariable String id, @RequestBody UserVO userVO) {
        UpdateUserRequest request = userConverter.vo2UpdateDto(userVO);
        CommonResponse response = userService.updateById(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            return RestResultFactory.getInstance().success(response);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "根据id，删除用户")
    @DeleteMapping("/{id}")
    public RestResult deleted(@PathVariable String id){
        CommonResponse response = userService.removeById(new IDRequest(id));
        return result(response);
    }

    @ApiOperation(value = "根据角色id,分页获取该角色下面的用户")
    @GetMapping("/page/role/{num}/{size}/{roleId}")
    public RestResult<Page<UserVO>> page(@PathVariable int num,
                                         @PathVariable int size,
                                         @PathVariable String roleId){
        CommonResponse<Page<UserDto>> response = userService.pageByRoleId(new UserRelationPageRequest(num,size,roleId));
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            Page<UserVO> res = userConverter.dto2Vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "根据角色id,分页获取该角色下面不存在的用户")
    @GetMapping("/page/role/not/{num}/{size}/{roleId}")
    public RestResult<Page<UserVO>> pageNotByRoleId(@PathVariable int num,
                                         @PathVariable int size,
                                         @PathVariable String roleId){
        CommonResponse<Page<UserDto>> response = userService.pageNotByRoleId(new UserRelationPageRequest(num,size,roleId));
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            Page<UserVO> res = userConverter.dto2Vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "根绝角色id，获取所有的用户id")
    @GetMapping("/role/{roleId}")
    public RestResult<String> getIdByRoleId(@PathVariable String roleId){
        CommonResponse<List<UserDto>> response = userService.listByRoleId(new UserListByRoleIdRequest(roleId));
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            String res = "";
            if (response.getData().size() > 0){
                StringBuilder builder = new StringBuilder();
                response.getData().forEach(item -> {
                    builder.append(item.getId());
                });
                res = builder.toString();
            }
            log.info("UserController.getIdByRoleId 返回值是：" + res);
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "根据角色id，批量进行用户角色绑定")
    @PostMapping("/batch/userrole/{roleId}")
    public RestResult createUserRole(@RequestBody UserRoleRequest request){
        CommonResponse response = userService.saveBatchUserRole(request);
        return result(response);
    }

}
