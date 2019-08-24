package com.hzqing.cloud.log.rest.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.cloud.log.api.dto.LoginLogDto;
import com.hzqing.cloud.log.api.service.ILoginLogService;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.rest.result.RestResult;
import com.hzqing.common.core.rest.result.RestResultFactory;
import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.request.PageRequest;
import com.hzqing.common.core.service.response.CommonResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzqing
 * @date 2019-08-21 13:31
 */
@RestController
@RequestMapping("/" + GlobalConstants.VERSION_V1 + "/login")
public class LoginLogController {

    @Reference(version = GlobalConstants.VERSION_V1)
    ILoginLogService loginLogService;


    @ApiOperation(value = "用户分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页展示数量", required = true, paramType = "path", dataType = "int")
    })
    @GetMapping("/page/{num}/{size}")
    public RestResult<Page<LoginLogDto>> page(@PathVariable int num,
                                              @PathVariable int size){
        CommonResponse<Page<LoginLogDto>> response = loginLogService.page(new PageRequest(num,size));
        return CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode()) ?
                RestResultFactory.getInstance().success(response.getData()) :
                RestResultFactory.getInstance().error();
    }

}
