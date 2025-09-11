package bst;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;




public class LeetCode<T extends Comparable<T>> {
    public BSTNode<T> searchBST(BSTNode<T> node, T val) {
        return searchBSTRec(node, val);
    }

     private BSTNode<T> searchBSTRec(BSTNode<T> node, T val) {
        BSTNode<T> result = new BSTNode<>();

        if(node != null && !node.isEmpty() && val != null){
            if(val.compareTo(node.getData()) < 0){
                result = this.searchBSTRec((BSTNode<T>) node.getLeft(), val);
            }
            else if(val.compareTo(node.getData()) > 0){
                result = this.searchBSTRec((BSTNode<T>) node.getRight(), val);
            }
            else{
                result = node;
            }
        }
        return result;
    }

    public List<T> preorderTraversal(BSTNode<T> node) {
        List<T> list = new ArrayList<>();
        preorderTraversal(node, list);
        return list;
    }

    private void preorderTraversal(BSTNode<T> node, List<T> list){
        if(node != null){
            list.add(node.getData());
            preorderTraversal((BSTNode<T>) node.getLeft(), list);
            preorderTraversal((BSTNode<T>) node.getRight(), list);
        }
    }

    public List<T> inorderTraversal(BSTNode<T> node) {
        List<T> list = new ArrayList<>();
        inorderTraversal(node, list);
        return list;
    }

    private void inorderTraversal(BSTNode<T> node, List<T> list){
        if(node != null){
            inorderTraversal((BSTNode<T>) node.getLeft(), list);
            list.add(node.getData());
            inorderTraversal((BSTNode<T>) node.getRight(), list);
        }
    }

    public List<T> postorderTraversal(BSTNode<T> node) {
        List<T> list = new ArrayList<>();
        postorderTraversal(node, list);
        return list;
    }

    private void postorderTraversal(BSTNode<T> node, List<T> list){
        if(node != null){
            postorderTraversal((BSTNode<T>) node.getLeft(), list);
            postorderTraversal((BSTNode<T>) node.getRight(), list);
            list.add(node.getData());
        }
    }

    public boolean checkTree(BSTNode<Integer> node) {
        return checkTreeRec(node);
    }

    private boolean checkTreeRec(BSTNode<Integer> node){ 
        boolean result = false; 
        if(node != null && !node.isEmpty()){ 
            result = node.getData() == node.getLeft().getData() + node.getRight().getData(); 
        } 
        return result; 
    }
    
    public BSTNode<T> mergeTrees(BSTNode<T> node1, BSTNode<T> node2){
        return mergeTreesRec(node1, node2);
    }

    public BSTNode<T> mergeTreesRec(BSTNode<T> node1, BSTNode<T> node2){
        BSTNode<T> result = new BSTNode<>();
        if(node1 == null || node1.isEmpty()){
            result = node2;
        }
        else if(node2 == null || node2.isEmpty()){
            result = node1;
        }
        else{
            Integer data1 = (Integer) node1.getData();
            Integer data2 = (Integer) node2.getData();
            Integer mergeData = data1 + data2;

            result = new BSTNode.Builder<T>().data((T) mergeData).build();

            result.setLeft(mergeTreesRec((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft()));
            result.setRight(mergeTreesRec((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight()));
            
        }
        return result;
    }

     public Integer sumOfLeftLeaves(BSTNode<Integer> root) {
        return sumOfLeftLeavesRec(root);
     }

     private Integer sumOfLeftLeavesRec(BSTNode<Integer> root) {
        int result = 0;

        if (root != null && !root.isEmpty()) {
            BSTNode<Integer> left = (BSTNode<Integer>) root.getLeft();

            if (left != null && !left.isEmpty()) {
                if (root.isLeaf2()) {
                    result += left.getData();
                }
            }

            result += sumOfLeftLeavesRec((BSTNode<Integer>) root.getLeft());
            result += sumOfLeftLeavesRec((BSTNode<Integer>) root.getRight());
        }

        return result;
    }

    public boolean isSymmetric(BSTNode<T> node){
        return isSymmetricRec((BSTNode<T>) node.getLeft(), (BSTNode<T>) node.getRight());
    }

    private boolean isSymmetricRec(BSTNode<T> n1, BSTNode<T> n2){
        boolean result = false;

        if ((n1 == null || n1.isEmpty()) && (n2 == null || n2.isEmpty())) {
            result = true;
        }
        else if (n1 == null || n2 == null || n1.isEmpty() || n2.isEmpty()) {
            result = false;
        }
        else if (!n1.getData().equals(n2.getData())) {
            result = false;
        }
        else {
            result = isSymmetricRec((BSTNode<T>) n1.getLeft(), (BSTNode<T>) n2.getRight()) && isSymmetricRec((BSTNode<T>) n1.getRight(), (BSTNode<T>) n2.getLeft());
        }

        return result;
    }

    public T kthSmallest(BSTNode<T> tree, int k) {
		T orderStatistic = null;
		if (tree != null && !tree.isEmpty() && k > 0) {
			orderStatistic = orderStatistic((BSTNode<T>) tree, k);
		}
		return orderStatistic;
	}

	private T orderStatistic(BSTNode<T> node, int k) {
		T result = null;
		if (!node.isEmpty()) {
			int sizeLeft = size((BSTNode<T>)node.getLeft());
			if ((k-1) == sizeLeft) {
				result = node.getData();
			} else if (k - 1 > sizeLeft) {
				result = orderStatistic((BSTNode<T>)node.getRight(), k - sizeLeft - 1);
			} else {
				result = orderStatistic((BSTNode<T>)node.getLeft(), k);
			}
		}

		return result;
	}

	private int size(BSTNode<T> node){
		int size = 0;
		if (node != null && !node.isEmpty()) {
			size = 1+ size((BSTNode<T>)node.getLeft()) + size((BSTNode<T>)node.getRight());
		}
		return size;
	}

     public static boolean hasPathSum(BSTNode<Integer> node, Integer target){
        return hasPathSumRec(node, target);
    }

    private static boolean hasPathSumRec(BSTNode<Integer> node, Integer target){
        boolean result = false;
        if(node != null || !node.isEmpty()){
            if(node.getLeft() == null && node.getRight() == null){
                result = target.equals(node.getData());
            }
            else{
                int difRoot = target - node.getData();
                result = hasPathSumRec((BSTNode<Integer>) node.getLeft(), difRoot) || hasPathSumRec((BSTNode<Integer>) node.getRight(), difRoot);
            }
        }
        return result;
    }

    public Integer rangeSumBST(BSTNode<T> node, int left, int right){
        return rangeSumBSTRec(node, left, right);
    }

    private Integer rangeSumBSTRec(BSTNode<T> node, int left, int right){
        Integer result = 0;

        if(node != null && !node.isEmpty()){
            if((Integer) node.getData() >= left && (Integer) node.getData() <= right){
                result += (Integer) node.getData();
            }
            if ((Integer) node.getData() > left){
                result += this.rangeSumBST((BSTNode<T>) node.getLeft(), left, right);
            }
            if ((Integer) node.getData() < right) {
                result += this.rangeSumBST((BSTNode<T>) node.getRight(), left, right);
            }
        }
        return result;
    }

    public void invertTree(BSTNode<T> node){
        this.invertTreeRec(node);
    }

    public void invertTreeRec(BSTNode<T> node){
        if(node != null && !node.isEmpty()){
            BSTNode<T> temp = (BSTNode<T>) node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);

            this.invertTreeRec((BSTNode<T>) node.getLeft());
            this.invertTreeRec((BSTNode<T>) node.getRight());
        }
    }

     public BSTNode<T> lowestCommonAncestor(BSTNode<T> node, T p, T q){
        return this.lowestCommonAncestorRec(node, p, q);
     }

     private BSTNode<T> lowestCommonAncestorRec(BSTNode<T> node, T p, T q){
        BSTNode<T> result = new BSTNode<>();

        if(node != null && !node.isEmpty()){
            T val = node.getData();
            T pVal = p;
            T qVal = q;

            if(pVal.compareTo(val) < 0 && qVal.compareTo(val) < 0){
                result = this.lowestCommonAncestorRec((BSTNode<T>) node.getLeft(), p, q);
            }
            else if(pVal.compareTo(val) > 0 && qVal.compareTo(val) > 0){
                result = this.lowestCommonAncestorRec((BSTNode<T>) node.getRight(), p, q);
            }
            else{
                result = node;
            }
        }
        return result;
     }

     public Integer minDiffInBST(BSTNode<Integer> node){
        Integer[] result = new Integer[]{-1, node.getData()};
        this.minDiffInBSTRec(node, result);
        return result[1];
     }

      private void minDiffInBSTRec(BSTNode<Integer> node, Integer[] last){

        if(node != null && !node.isEmpty()){
            this.minDiffInBSTRec((BSTNode<Integer>) node.getLeft(), last);

            if(last[0] != -1){
                Integer dif = node.getData() - last[0];
                if(dif < last[1]){
                    last[1] = dif;
                }
            }
            
            last[0] = node.getData();

           this.minDiffInBSTRec((BSTNode<Integer>)node.getRight(), last);
        }
      }

      public int diameterOfBinaryTree(BSTNode<T> node){
        int result = 0;

        if(node != null && !node.isEmpty()){
            int leftH = diameterOfBinaryTreeRec((BSTNode) node.getLeft());
            int rightH = diameterOfBinaryTreeRec((BSTNode) node.getRight());
            int d1 = diameterOfBinaryTree((BSTNode)node.getLeft());
            int d2 = diameterOfBinaryTree((BSTNode)node.getRight());
    
            int max = 0;
            if(d1 > d2){
                max = d1;
            }
            else{
                max = d2;
            }
    
            int sumH = leftH + rightH;
            if(sumH > max){
                result = sumH;
            }
            else{
                result = max;
            }

        }

        return result;
      }

      private int diameterOfBinaryTreeRec(BSTNode<T> node){
        int result = 0;
        if(node != null && !node.isEmpty()){
            result = 1 + Math.max(diameterOfBinaryTreeRec((BSTNode) node.getLeft()), diameterOfBinaryTreeRec((BSTNode) node.getRight()));
        }
        return result;
      }

      public Integer sumNumbers(BSTNode root) {
        return sumNumbersRec(root, 0);
    }
    
    public Integer sumNumbersRec(BSTNode root, int cur) {
        Integer result = 0;

        if(root != null && !root.isEmpty()){
            int next = cur * 10 + (Integer) root.getData();

            if(root.getLeft() == null && root.getRight() == null){
                result = next;
            }
            else{
                result = this.sumNumbersRec((BSTNode) root.getLeft(), next) + this.sumNumbersRec((BSTNode) root.getRight(), next);
            }
        }
        return result;
    }   
}