package com.kuibu.algorithm.other;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RebuildTree {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param preOrder int整型一维数组 先序遍历
     * @param inOrder int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] preOrder, int[] inOrder) {
        if(preOrder == null || preOrder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inOrderIdxMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inOrder.length; i++) {
            inOrderIdxMap.put(inOrder[i], i);
        }

        TreeNode root = buildTree(inOrderIdxMap, preOrder, inOrder, 0, 0, inOrder.length - 1);

        List<Integer> res = new ArrayList<Integer>();
        traverse(root, 0, res);

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public TreeNode buildTree(Map<Integer, Integer> inOrderIdxMap, int[] preOrder, int[] inOrder,
                              int preStart, int inStart, int inEnd) {
        if(preStart > preOrder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);

        int rootIndex = inOrderIdxMap.get(preOrder[preStart]);

        root.left = buildTree(inOrderIdxMap, preOrder, inOrder, preStart + 1, inStart, rootIndex - 1);
        root.right = buildTree(inOrderIdxMap, preOrder, inOrder,
                preStart + (rootIndex - inStart) + 1, rootIndex + 1, inEnd);

        return root;
    }

    public void traverse(TreeNode root, int level, List<Integer> res) {
        if(root == null) {
            return ;
        }

        if(res.size() == level) {
            res.add(root.val);
        }

        traverse(root.right, level + 1, res);
        traverse(root.left, level + 1, res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.val = value;
    }
}