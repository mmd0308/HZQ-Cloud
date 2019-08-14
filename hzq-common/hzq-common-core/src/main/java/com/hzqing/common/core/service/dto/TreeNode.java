package com.hzqing.common.core.service.dto;

import lombok.Data;

import java.util.List;

/**
 * 通用树型节点
 * @author hzqing
 * @date 2019-08-14 11:37
 */
@Data
public class TreeNode<T extends TreeNode> extends BaseDto{

    private static final long serialVersionUID = 3242205198177855774L;

    private Integer id;

    private Integer parentId;

    private List<T>  children;

}
