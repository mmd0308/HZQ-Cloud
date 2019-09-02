package com.hzqing.system.rest.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-14 11:46
 */
@Data
@ToString(callSuper = true)
public class MenuTreeVO extends MenuVO {

    private List<MenuTreeVO> children;
}
