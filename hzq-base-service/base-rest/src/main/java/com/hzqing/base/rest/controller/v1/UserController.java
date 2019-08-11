package com.hzqing.base.rest.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.user.UserDetailRequest;
import com.hzqing.base.api.dto.user.UserDto;
import com.hzqing.base.api.dto.user.UserPageRequest;
import com.hzqing.base.api.service.IUserService;
import com.hzqing.base.rest.vo.UserVO;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.rest.result.RestResult;
import com.hzqing.common.core.rest.result.RestResultFactory;
import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * @author hzqing
 * @date 2019-08-11 09:54
 */
@Api(tags = "用户管理模块")
@RestController
@RequestMapping("/"+ GlobalConstants.VERSION_V1 +"/users")
public class UserController {

    @Reference(version = GlobalConstants.VERSION_V1)
    private IUserService userService;

    @GetMapping("/{id}")
    public RestResult<UserDto> get(@PathVariable int id){
        UserDetailRequest request = new UserDetailRequest();
        request.setId(id);
        CommonResponse<UserDto> response = userService.userDetail(request);

        if (response.getCode().equals(CommonRetCodeConstants.SUCCESS.getCode())){
            return RestResultFactory.getInstance().successBuild(response.getData());
        }
        return RestResultFactory.getInstance().errorBuild();
    }

    @ApiOperation(value = "用户分页分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页展示数量", required = true, paramType = "path", dataType = "int")
    })
    @GetMapping("/page/{num}/{size}")
    public RestResult<Page<UserDto>> page(@PathVariable int num,@PathVariable int size,UserVO userVO){
        UserPageRequest request = new UserPageRequest();
        request.setPageNum(num);
        request.setPageSize(size);
        CommonResponse<Page<UserDto>> response = userService.userPage(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            return RestResultFactory.getInstance().successBuild(response.getData());
        }
        return RestResultFactory.getInstance().errorBuild();
    }

//    @GetMapping
//    public RestResult<List<UserDto>> list(){
//        CommonResponse<List<UserDto>> response = userService.userLists(new UserListRequest());
//        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
//            return RestResultFactory.getInstance().successBuild(response.getData());
//        }
//        return RestResultFactory.getInstance().errorBuild();
//    }

    @PostMapping
    public RestResult add(@RequestBody UserVO userVO){
        System.out.println(userVO);
        return null;
    }

}
