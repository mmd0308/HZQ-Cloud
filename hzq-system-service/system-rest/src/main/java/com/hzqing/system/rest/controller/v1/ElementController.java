package com.hzqing.system.rest.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.common.core.service.request.PermissionRequest;
import com.hzqing.system.api.dto.button.*;
import com.hzqing.system.api.service.IElementService;
import com.hzqing.system.rest.converter.ElementConverter;
import com.hzqing.system.rest.vo.ElementVO;
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
 * 元素资源模块模块管理，包括按钮，连接等
 * @author hzqing
 * @date 2019-08-11 12:12
 */
@Api(tags="元素资源模块模块管理，包括按钮，连接等")
@Slf4j
@RestController
@RequestMapping("/" + GlobalConstants.VERSION_V1 + "/elements")
public class ElementController extends BaseController {


    @Reference(version = GlobalConstants.VERSION_V1)
    IElementService elementService;

    @Autowired
    ElementConverter elementConverter;

    @ApiOperation(value = "根据id获取资源")
    @GetMapping("/{id}")
    public RestResult<ElementVO> get(@PathVariable String id) {
        CommonResponse<ElementDto> response = elementService.getById(new IDRequest(id));
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            ElementVO res = elementConverter.dto2vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "按钮分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页展示数量", required = true, paramType = "path", dataType = "int")
    })
    @GetMapping("/page/{num}/{size}")
    public RestResult<Page<ElementVO>> page(@PathVariable int num, @PathVariable int size, ElementVO elementVO){
        log.info("ElementController.page request: " + elementVO);
        ElementPageRequest request = new ElementPageRequest();
        request.setPageNum(num);
        request.setPageSize(size);
        request.setMenuId(elementVO.getMenuId());
        CommonResponse<Page<ElementDto>> response = elementService.page(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            Page<ElementVO> res = elementConverter.dto2Vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }
    @ApiOperation(value = "创建按钮")
    @PostMapping
    public RestResult create(@RequestBody ElementVO buttonVO){
        log.info("ElementController.create request vo : " + buttonVO);
        AddElementRequest request = elementConverter.vo2Dto(buttonVO);
        CommonResponse response = elementService.save(request);
        return result(response);
    }

    @ApiOperation(value = "根据条件获取所有的资源")
    @GetMapping
    public RestResult list(ElementVO elementVO){
        log.info("ElementController.list request: " + elementVO);
        ElementListRequest request = elementConverter.vo2ListDto(elementVO);
        CommonResponse<List<ElementDto>> response = elementService.list(request);
        return CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode()) ?
                RestResultFactory.getInstance().success(response.getData()) :
                RestResultFactory.getInstance().error();
    }

    @ApiOperation(value = "根据id，更新按钮")
    @PutMapping("/{id}")
    public RestResult update(@PathVariable String id, @RequestBody ElementVO ButtonVO) {
        UpdateElementRequest request = elementConverter.vo2UpdateDto(ButtonVO);
        request.setId(id);
        CommonResponse response = elementService.updateById(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，删除删除")
    @DeleteMapping("/{id}")
    public RestResult deleted(@PathVariable String id){
        CommonResponse response = elementService.removeById(new IDRequest(id));
        return result(response);
    }

    @ApiOperation(value = "检查权限编码是否可用，true表示可用，false表示不可用")
    @GetMapping("/permission/{permission}")
    public RestResult<Boolean> checkPermission(@PathVariable String permission,String id){
        CommonResponse<Boolean> response = elementService.checkPermission(new PermissionRequest(permission, id));
        return CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode()) ?
                RestResultFactory.getInstance().success(response.getData()) :
                RestResultFactory.getInstance().error();
    }
}
