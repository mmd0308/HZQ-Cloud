package com.hzqing.common.core.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-14 10:54
 */
public class TreeUtils {
    private TreeUtils() {
        new Exception("私有构造，不能实例话.");
    }

    /**
     * 根据列表，构建树行结果
     * @param parentId
     * @param list
     * @return
     */
    public static <T extends TreeNode> List<T> buildTree(String parentId , List<T> list){
        List<T> res = new ArrayList<>(list.size());
        list.forEach(item -> {
            if (parentId.equals(item.getParentId())) { // 表示是父节点
                res.add(findChild(item,list));
            }
        });
        return res;
    }

    private static <T extends TreeNode> T findChild(T response, List<T> list) {
        list.forEach(item  -> {
            if (response.getId().equals(item.getParentId())){
                if(response.getChildren() == null) {
                    response.setChildren(new ArrayList<T>());
                }
                response.getChildren().add(findChild(item, list));
            }
        });
        return response;
    }
}
