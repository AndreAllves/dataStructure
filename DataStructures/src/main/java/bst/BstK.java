package bst;

import bt.BTNode;

public class BstK<T extends Comparable <T>> extends BSTNode<T> {
    BSTNode<T> root;

    public T bstK(int k){
        T result = null;
        if(!root.isEmpty() && k > 0){
            int [] count = {k};
                BSTNode<T> temp = bstKrecurisve(root, count);
                result = temp.getData();
        }
        return result;
    }

    private BSTNode<T> bstKrecurisve(BSTNode<T> node, int[] count){
        BSTNode<T> out = null;

        if(node.isEmpty()){
            return out;
        }

        BSTNode<T> left = bstKrecurisve((BSTNode<T>) node.getLeft(), count);

        if(left != null){
            out = left;
        }

        count[0]--;

        if (count[0] == 0){
            out = node;
        }
        else{
            out = bstKrecurisve((BSTNode<T>) node.getRight(), count);
        }
        return out;
    }

    public BSTNode<T> search(T elem) {
        return this.search(elem, root);
    }

    private BSTNode<T> search(T elem, BSTNode<T> node){
        BSTNode<T> founded = new BSTNode<T>();
        if(elem != null && !node.isEmpty()){
            if(elem.compareTo(node.getData()) < 0){
                founded = this.search(elem, (BSTNode<T>) node.getLeft());
            }
            else if(elem.compareTo(node.getData()) > 0){
                founded = this.search(elem, (BSTNode<T>) node.getRight());
            }
            else{
                founded = node;
            }
        }
        return founded;
    }

    public void insert(T data){
        if(data != null && this.search(data).isEmpty()) {
            this.insert(data, root);
       }
    }

    private void insert(T data, BSTNode<T> node){
        if(node.isEmpty()){
            node.setData(data);
            node.setLeft(new BTNode<T>());
            node.setRight(new BSTNode<T>());
            node.getLeft().setParent(node);
            node.getRight().setParent(node);
        }
        else{
            if(node.getData().compareTo(data) < 0){
                this.insert(data, (BSTNode<T>) node.getLeft());
            }
            else{
                this.insert(data, (BSTNode<T>) node.getRight());
            }
        }
    }
}
