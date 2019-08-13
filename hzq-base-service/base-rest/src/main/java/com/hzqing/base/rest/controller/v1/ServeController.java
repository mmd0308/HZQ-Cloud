package com.hzqing.base.rest.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.serve.*;
import com.hzqing.base.api.service.IServeService;
import com.hzqing.base.rest.converter.ServeConverter;
import com.hzqing.base.rest.vo.ServeVO;
import com.hzqing.common.core.constants.GlobalConstants;
import com.hzqing.common.core.rest.controller.BaseController;
import com.hzqing.common.core.rest.result.RestResult;
import com.hzqing.common.core.rest.result.RestResultFactory;
import com.hzqing.common.core.service.constants.CommonRetCodeConstants;
import com.hzqing.common.core.service.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 服务管理模块
 * @author hzqing
 * @date 2019-08-11 12:12
 */
@Api(tags = "服务管理模块")
@RestController
@RequestMapping("/base/" + GlobalConstants.VERSION_V1 + "/serves")
public class ServeController extends BaseController {


    @Reference(version = GlobalConstants.VERSION_V1)
    IServeService serveService;

    @Autowired
    ServeConverter serveConverter;

    @ApiOperation(value = "根据id获取菜单")
    @GetMapping("/{id}")
    public RestResult<ServeVO> get(@PathVariable int id) {
        ServeDetailRequest request = new ServeDetailRequest();
        request.setId(id);
        CommonResponse<ServeDto> response = serveService.serveDetail(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            ServeVO res = serveConverter.dto2vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "服务分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页展示数量", required = true, paramType = "path", dataType = "int")
    })
    @GetMapping("/page/{num}/{size}")
    public RestResult<Page<ServeVO>> page(@PathVariable int num, @PathVariable int size, ServeVO serveVO){
        ServePageRequest request = new ServePageRequest();
        request.setPageNum(num);
        request.setPageSize(size);
        CommonResponse<Page<ServeDto>> response = serveService.servePage(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            Page<ServeVO> res = serveConverter.dto2Vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }
    @ApiOperation(value = "创建服务")
    @PostMapping
    public RestResult create(@RequestBody ServeVO ServeVO){
        AddServeRequest request = serveConverter.vo2Dto(ServeVO);
        CommonResponse response = serveService.createServe(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，更新服务")
    @PutMapping("/{id}")
    public RestResult update(@PathVariable int id, @RequestBody ServeVO ServeVO) {
        UpdateServeRequest request = serveConverter.vo2UpdateDto(ServeVO);
        request.setId(id);
        CommonResponse response = serveService.updateServe(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，删除删除")
    @DeleteMapping("/{id}")
    public RestResult deleted(@PathVariable int id){
        DeleteServeRequest request = new DeleteServeRequest();
        request.setId(id);
        CommonResponse response = serveService.deleteServe(request);
        return result(response);
    }
}
