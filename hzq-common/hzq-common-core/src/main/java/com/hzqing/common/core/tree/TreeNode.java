package com.hzqing.common.core.tree;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 通用树型节点
 * @author hzqing
 * @date 2019-08-14 11:37
 */
@Data
public class TreeNode<T extends TreeNode> implements Serializable {


    private static final long serialVersionUID = 4172872351913197941L;
    
    private String id;

    private String parentId;

    private List<T>  children;

}
