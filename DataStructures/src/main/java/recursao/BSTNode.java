package recursao;


public class BSTNode<T extends Comparable<T>> {
    
    private T data;
    private BSTNode<T> left;
    private BSTNode<T> right;
    private BSTNode<T> parent;

    public BSTNode() {
        this(null, null, null, null);
    }

    public BSTNode(T data) {
        this(data, null, null, null);
    }

    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

    public BSTNode<T> getParent() {
        return parent;
    }

    public void setParent(BSTNode<T> parent) {
        this.parent = parent;
    }

    public boolean isEmpty() {
        return this.data == null;
    }

    public boolean isLeaf() {
        return this.data != null && this.left.isEmpty() && this.right.isEmpty();
    }

    @Override
    public String toString() {
        return (data == null) ? "NIL" : data.toString();
    }
}
