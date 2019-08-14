package com.hzqing.base.rest.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.user.*;
import com.hzqing.base.api.service.IUserService;
import com.hzqing.base.rest.converter.UserConverter;
import com.hzqing.base.rest.vo.UserVO;
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
 * @author hzqing
 * @date 2019-08-11 09:54
 */
@Api(tags = "用户管理模块")
@RestController
@RequestMapping("/base/"+ GlobalConstants.VERSION_V1 +"/users")
public class UserController extends BaseController {

    @Reference(version = GlobalConstants.VERSION_V1)
    private IUserService userService;

    @Autowired
    private UserConverter userConverter;

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/{id}")
    public RestResult<UserVO> get(@PathVariable int id){
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
    public RestResult<Page<UserVO>> page(@PathVariable int num,@PathVariable int size,UserVO userVO){
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
    public RestResult update(@PathVariable int id, @RequestBody UserVO userVO) {
        UpdateUserRequest request = userConverter.vo2UpdateDto(userVO);
        CommonResponse response = userService.updateById(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            return RestResultFactory.getInstance().success(response);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "根据id，删除用户")
    @DeleteMapping("/{id}")
    public RestResult deleted(@PathVariable int id){
        CommonResponse response = userService.removeById(new IDRequest(id));
        return result(response);
    }

}
