package bst;

import java.util.ArrayList;

import bt.BTNode;

public class BSTI<T extends Comparable<T>>  implements BST<T> {

    protected BSTNode<T> root;

    public BSTI(){
        this.root = new BSTNode<T>();
    }

    @Override
    public BSTNode<T> getRoot() {
        return this.root;
    }

    @Override
    public boolean isEmpty() {
       return this.getRoot().isEmpty();
    }

    @Override
    public int height() {
        return this.height(this.getRoot());
    }

    private int height(BSTNode<T> node){
        int height = -1;
        if(!node.isEmpty()){
            height = 1 + Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight()));
        }
        return height;
    }

    @Override
    public BSTNode<T> search(T elem) {
        return this.search(elem, this.getRoot());
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

    @Override
   public void insert(T element) {
		if (element != null && search(element).isEmpty()) {
			this.insert(this.getRoot(), element);
		}

	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else {
			if (node.getData().compareTo(element) > 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else {
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

    @Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		remove(node);
	}

    private void remove(BSTNode<T> node){
        if(node != null && !node.isEmpty()){
            if(node.isLeaf()){
                node.setData(null);
            }
            else if(this.hasOnlyChild(node)){
                if(node.getParent() != null){
                    if(node.getParent().getData().compareTo(node.getData()) > 0){
                        if(!node.getLeft().isEmpty()){
                            node.getParent().setLeft(node.getLeft());
                            node.getParent().setParent(node.getParent());
                        }
                        else{
                            node.getParent().setLeft(node.getRight());
                            node.getRight().setParent(node.getParent());
                        }
                    }
                    else{
                        if(!node.getRight().isEmpty()){
                            node.getParent().setRight(node.getLeft());
                            node.getRight().setParent(node.getParent());
                        }
                        else{
                            node.getParent().setRight(node.getRight());
                            node.getRight().setParent(node.getParent());
                        }
                    }
                }
                else{
                    if(node.getLeft().isEmpty()){
                        root = (BSTNode<T>) node.getRight();
                        root.setParent(null);
                    }
                    else{
                        root = (BSTNode<T>) node.getLeft();
                        root.setParent(null);
                    }
                }
            }
            else{
                BSTNode<T> successor = sucessor(node.getData());
                node.setData(successor.getData());
                remove(successor);
            }
        }
    }

    private boolean hasOnlyChild(BSTNode<T> node){
        return (node.getLeft().isEmpty() && !node.getRight().isEmpty()) || (!node.getLeft().isEmpty() && node.getRight().isEmpty()); 
    }

    @Override
    public T[] preOrder() {
        ArrayList<T> list = new ArrayList<T>();
        this.preOrder(list, this.getRoot());
        return (T[]) list.toArray(new Comparable[list.size()]);   
       
    }

    private void preOrder(ArrayList<T> list, BSTNode<T> node){
        if(node != null && !node.isEmpty()){
            list.add(node.getData());
            this.preOrder(list, (BSTNode<T>) node.getLeft());
            this.preOrder(list, (BSTNode<T>) node.getRight());
        }
    }

    @Override
    public T[] order() {
        ArrayList<T> list = new ArrayList<>();
        this.order(list, this.getRoot());
        return (T[]) list.toArray(new Comparable[list.size()]);
    }

    private void order(ArrayList<T> list, BSTNode<T> node){
        if(node != null && !node.isEmpty()){
            this.order(list, (BSTNode<T>) node.getLeft());
            list.add(node.getData());
            this.order(list, (BSTNode<T>) node.getRight());
        }
    }

    @Override
    public T[] postOrder() {
        ArrayList<T> list = new ArrayList<>();
        this.postOrder(list, this.getRoot());
        return (T[]) list.toArray(new Comparable[list.size()]);
    }

    private void postOrder(ArrayList<T> list, BSTNode<T> node){
        if(node != null && !node.isEmpty()){
            this.postOrder(list, (BSTNode<T>) node.getLeft());
            this.postOrder(list, (BSTNode<T>) node.getRight());
            list.add(node.getData());
        }
    }

    @Override
    public BSTNode<T> maximum() {
        BSTNode<T> out = null;

        if(!this.isEmpty()){
            out = this.maximum(this.getRoot());
        }

        return out;
    }

    private BSTNode<T> maximum(BSTNode<T> node){
        BSTNode<T> out = node;
        
        if(!node.getRight().isEmpty()){
            out = this.maximum((BSTNode<T>) node.getRight());
        }

        return out;
    }

    @Override
    public BSTNode<T> minimum() {
        BSTNode<T> out = null;

        if(!this.isEmpty()){
            this.minimum(this.getRoot());
        }
        return out;
    }

    private BSTNode<T> minimum(BSTNode<T> node){
        BSTNode<T> out = node;

        if(!node.getLeft().isEmpty()){
            out = this.minimum((BSTNode<T>) node.getLeft());
        }
        return out;
    }

    @Override
    public BSTNode<T> sucessor(T element) {
        BSTNode<T> out = null;
        BSTNode<T> node = this.search(element);

        if(!node.isEmpty()){
            if(!node.getRight().isEmpty()){
                out = this.minimum((BSTNode<T>) node.getRight());
            }
            else{
                out = this.sucessor(node);
            }
        }
        return out;
    }

    private BSTNode<T> sucessor(BSTNode<T> node){
        BSTNode<T> out = (BSTNode<T>) node.getParent();

        if(node.getParent() != null && !out.isEmpty() && node.equals(out.getRight())){
            out = this.sucessor((BSTNode<T>) node.getParent());
        }
        return out;
    }

    @Override
    public BSTNode<T> predecessor(T element) {
        BSTNode<T> out = null;
        BSTNode<T> node = this.search(element);

        if(!node.isEmpty()){
            if(!node.getLeft().isEmpty()){
                out = this.minimum((BSTNode<T>) node.getLeft());
            }
            else{
                out = this.sucessor(node);
            }
        }
        return out;
    }

    private BSTNode<T> predecessor(BSTNode<T> node){
        BSTNode<T> out = (BSTNode<T>) node.getParent();

        if(node.getParent() != null && !out.isEmpty() && node.equals(out.getLeft())){
            out = this.predecessor((BSTNode<T>) node.getParent());
        }
        return out;
    }

    @Override
	public int size() {
      return this.size(this.getRoot());
    }

    private int size(BSTNode<T> node){
        int out = 0;

        if(!node.isEmpty()){
            out = 1 + this.size((BSTNode<T>) node.getLeft()) + this.size((BSTNode<T>) node.getRight());
        }
        return out;
    }   
}