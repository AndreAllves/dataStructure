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

     public Integer minDiffInBST(BSTNode<T> node){
        return minDiffInBSTRec(node, null, Integer.MAX_VALUE);
     }

      private Integer minDiffInBSTRec(BSTNode<T> node, T last, Integer minDiff){
        Integer result = minDiff;

        if(node != null && !node.isEmpty()){
            minDiff = minDiffInBSTRec((BSTNode<T>) node.getLeft(), last, minDiff);

            if(last != null){
                minDiff = minDiff.compareTo((Integer) node.getData() - (Integer) last) < 0 ? minDiff : (Integer) node.getData() - (Integer) last;
            }
            minDiff = minDiffInBSTRec((BSTNode<T>) node.getRight(), node.getData(), minDiff);
        }
        return minDiff;
      }


    public static void main(String[] args) {
        LeetCode<Integer> test = new LeetCode<>();

        BSTI bst = new BSTI<>();
        Integer[] a = new Integer[]{1,2,3,4,5,6,7,8};
        for(Integer val : a) bst.insert(val);

            BSTNode<Integer> emptyNode = new BSTNode<>();


          BSTNode<Integer> root = new BSTNode.Builder<Integer>()
        .data(10)
        .left(new BSTNode.Builder<Integer>().data(4)
            .left(emptyNode)
            .right(emptyNode)
            .build())
        .right(new BSTNode.Builder<Integer>().data(6)
            .left(emptyNode)
            .right(emptyNode)
            .build())
        .build();

          // Árvore 1
        BSTNode<Integer> root1 = new BSTNode.Builder<Integer>()
                .data(1)
                .left(new BSTNode.Builder<Integer>().data(3)
                        .left(new BSTNode.Builder<Integer>().data(5).build())
                        .build())
                .right(new BSTNode.Builder<Integer>().data(2).build())
                .build();

        // Árvore 2
        BSTNode<Integer> root2 = new BSTNode.Builder<Integer>()
                .data(2)
                .left(new BSTNode.Builder<Integer>().data(1)
                        .right(new BSTNode.Builder<Integer>().data(4).build())
                        .build())
                .right(new BSTNode.Builder<Integer>().data(3)
                        .right(new BSTNode.Builder<Integer>().data(7).build())
                        .build())
                .build();

        BSTNode<Integer> merged = test.mergeTrees(root1, root2);
            

        BSTNode<Integer> root23 = new BSTNode.Builder<Integer>()
            .data(3)
            .left(new BSTNode.Builder<Integer>().data(9).build())
            .right(new BSTNode.Builder<Integer>()
                    .data(20)
                    .left(new BSTNode.Builder<Integer>().data(15).build())
                    .right(new BSTNode.Builder<Integer>().data(7).build())
                    .build())
            .build();

             // Teste 1: simétrica
        BSTNode<Integer> root12 = new BSTNode.Builder<Integer>()
                .data(1)
                .left(new BSTNode.Builder<Integer>()
                        .data(2)
                        .left(new BSTNode.Builder<Integer>().data(3).build())
                        .right(new BSTNode.Builder<Integer>().data(4).build())
                        .build())
                .right(new BSTNode.Builder<Integer>()
                        .data(2)
                        .left(new BSTNode.Builder<Integer>().data(4).build())
                        .right(new BSTNode.Builder<Integer>().data(3).build())
                        .build())
                .build();

        BSTNode<Integer> root32 = new BSTNode.Builder<Integer>()
        .data(5)
        .left(new BSTNode.Builder<Integer>()
                .data(3)
                .left(new BSTNode.Builder<Integer>().data(2).build())
                .right(new BSTNode.Builder<Integer>().data(4).build())
                .build())
        .right(new BSTNode.Builder<Integer>()
                .data(7)
                .left(new BSTNode.Builder<Integer>().data(6).build())
                .right(new BSTNode.Builder<Integer>().data(8).build())
                .build())
        .build();

        BSTNode<Integer> root34 = new BSTNode.Builder<Integer>().data(5).build();
        BSTNode<Integer> n4 = new BSTNode.Builder<Integer>().data(4).build();
        BSTNode<Integer> n8 = new BSTNode.Builder<Integer>().data(8).build();
        BSTNode<Integer> n11 = new BSTNode.Builder<Integer>().data(11).build();
        BSTNode<Integer> n13 = new BSTNode.Builder<Integer>().data(13).build();

        // conecta
       root34.setLeft(n4);
        root34.setRight(n8);
        n8.setLeft(n11);
        n8.setRight(n13);

        BSTNode<Integer> root73 = new BSTNode.Builder<Integer>().data(10).build();
        BSTNode<Integer> n5 = new BSTNode.Builder<Integer>().data(5).build();
        BSTNode<Integer> n15 = new BSTNode.Builder<Integer>().data(15).build();
        BSTNode<Integer> n3 = new BSTNode.Builder<Integer>().data(3).build();
        BSTNode<Integer> n7 = new BSTNode.Builder<Integer>().data(7).build();
        BSTNode<Integer> n18 = new BSTNode.Builder<Integer>().data(18).build();

        root73.setLeft(n5);
        root73.setRight(n15);
        n5.setLeft(n3);
        n5.setRight(n7);
        n15.setRight(n18);

        BSTNode<Integer> root5 = new BSTNode.Builder<Integer>()
        .data(4)
        .left(new BSTNode.Builder<Integer>()
            .data(2)
            .left(new BSTNode.Builder<Integer>().data(1).build())
            .right(new BSTNode.Builder<Integer>().data(3).build())
            .build())
        .right(new BSTNode.Builder<Integer>()
            .data(7)
            .left(new BSTNode.Builder<Integer>().data(6).build())
            .right(new BSTNode.Builder<Integer>().data(9).build())
            .build())
        .build();


        BSTNode<Integer> root67 = new BSTNode.Builder<Integer>()
        .data(6)
        .left(new BSTNode.Builder<Integer>()
            .data(2)
            .left(new BSTNode.Builder<Integer>().data(0).build())
            .right(new BSTNode.Builder<Integer>()
                .data(4)
                .left(new BSTNode.Builder<Integer>().data(3).build())
                .right(new BSTNode.Builder<Integer>().data(5).build())
                .build())
            .build())
        .right(new BSTNode.Builder<Integer>()
            .data(8)
            .left(new BSTNode.Builder<Integer>().data(7).build())
            .right(new BSTNode.Builder<Integer>().data(9).build())
            .build())
        .build();

        BSTNode<Integer> root56 = new BSTNode.Builder<Integer>()
        .data(4)
        .left(new BSTNode.Builder<Integer>()
            .data(2)
            .left(new BSTNode.Builder<Integer>().data(1).build())
            .right(new BSTNode.Builder<Integer>().data(3).build())
            .build())
        .right(new BSTNode.Builder<Integer>()
            .data(6)
            .build())
        .build();
        
        //System.out.println(test.searchBST(bst.getRoot(), 12));
        //System.out.println(test.preorderTraversal(bst.getRoot()));
        //System.out.println(test.inorderTraversal(bst.getRoot()));
        //System.out.println(test.checkTree(root));
        //printPreOrder(merged); 
        //System.out.println(test.sumOfLeftLeaves(root23));
        //System.out.println(test.isSymmetric(root12));
        //System.out.println(test.kthSmallest(root32, 1));
        //System.out.println(test.hasPathSum(root34, 24));
        //System.out.println(test.rangeSumBST(root73, 7, 15));
        // System.out.print("Pré-ordem antes da inversão: ");
        // printPreOrder(root5);
        // System.out.println();
        // test.invertTree(root5);
        // System.out.print("Pré-ordem depois da inversão: ");
        // printPreOrder(root5);
        // System.out.println()
        //System.out.println(test.lowestCommonAncestor(root67, 2, 8).getData());
          System.out.println("Diferença mínima: " + test.minDiffInBST(root56)); // esperado: 1
        
    }

    private static void printPreOrder(BSTNode<Integer> node) {
        if (node == null) return;
        System.out.print(node.getData() + " ");
        printPreOrder((BSTNode<Integer>) node.getLeft());
        printPreOrder((BSTNode<Integer>) node.getRight());
    }
}