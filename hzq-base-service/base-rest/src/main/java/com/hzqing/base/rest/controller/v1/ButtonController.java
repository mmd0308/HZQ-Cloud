package com.hzqing.base.rest.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzqing.base.api.dto.button.AddButtonRequest;
import com.hzqing.base.api.dto.button.ButtonDto;
import com.hzqing.base.api.dto.button.ButtonPageRequest;
import com.hzqing.base.api.dto.button.UpdateButtonRequest;
import com.hzqing.base.api.service.IButtonService;
import com.hzqing.base.rest.converter.ButtonConverter;
import com.hzqing.base.rest.vo.ButtonVO;
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

/**
 * 按钮管理模块
 * @author hzqing
 * @date 2019-08-11 12:12
 */
@Api(tags="按钮模块模块管理")
@Slf4j
@RestController
@RequestMapping("/base/" + GlobalConstants.VERSION_V1 + "/buttons")
public class ButtonController extends BaseController {


    @Reference(version = GlobalConstants.VERSION_V1)
    IButtonService buttonService;

    @Autowired
    ButtonConverter buttonConverter;

    @ApiOperation(value = "根据id获取菜单")
    @GetMapping("/{id}")
    public RestResult<ButtonVO> get(@PathVariable int id) {
        CommonResponse<ButtonDto> response = buttonService.getById(new IDRequest(id));
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            ButtonVO res = buttonConverter.dto2vo(response.getData());
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
    public RestResult<Page<ButtonVO>> page(@PathVariable int num, @PathVariable int size, ButtonVO buttonVO){
        ButtonPageRequest request = new ButtonPageRequest();
        request.setPageNum(num);
        request.setPageSize(size);
        CommonResponse<Page<ButtonDto>> response = buttonService.page(request);
        if (CommonRetCodeConstants.SUCCESS.getCode().equals(response.getCode())){
            Page<ButtonVO> res = buttonConverter.dto2Vo(response.getData());
            return RestResultFactory.getInstance().success(res);
        }
        return RestResultFactory.getInstance().error();
    }
    @ApiOperation(value = "创建按钮")
    @PostMapping
    public RestResult create(@RequestBody ButtonVO buttonVO){
        log.info("ButtonController.create request vo : " + buttonVO);
        AddButtonRequest request = buttonConverter.vo2Dto(buttonVO);
        CommonResponse response = buttonService.save(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，更新按钮")
    @PutMapping("/{id}")
    public RestResult update(@PathVariable int id, @RequestBody ButtonVO ButtonVO) {
        UpdateButtonRequest request = buttonConverter.vo2UpdateDto(ButtonVO);
        request.setId(id);
        CommonResponse response = buttonService.updateById(request);
        return result(response);
    }

    @ApiOperation(value = "根据id，删除删除")
    @DeleteMapping("/{id}")
    public RestResult deleted(@PathVariable int id){
        CommonResponse response = buttonService.removeById(new IDRequest(id));
        return result(response);
    }
}
