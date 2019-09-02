package com.hzqing.system.rest.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-16 08:04
 */
@Data
@ToString(callSuper = true)
public class RoleTreeVO extends RoleVO{

    private List<RoleTreeVO> children;
}
