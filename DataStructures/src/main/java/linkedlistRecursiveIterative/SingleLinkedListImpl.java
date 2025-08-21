package linkedlistRecursiveIterative;

public class SingleLinkedListImpl<T> extends SingleLinkedListNode<T> {
    protected SingleLinkedListNode<T> head;

    public SingleLinkedListImpl(){
        this.head = new SingleLinkedListNode<>();
    }


    public SingleLinkedListNode<T> getHead(){
        return head;
    }

    public void setHead(SingleLinkedListNode<T> head){
        this.head = head;
    }

    public boolean isEmpty() {
        return this.getHead().isNil();
    }

    public int size(){
        return this.recursiveSize(this.getHead());
    }

    private int recursiveSize(SingleLinkedListNode<T> node){
        int out = 0;
        if(node != null && !node.isNil()){
            out = 1 + recursiveSize(node.getNext());
        }
        return out;
    }

    public void insert(T element){
        if(element != null){
            recursiveInsert(this.getHead(), element);
        }
    }

    private void recursiveInsert(SingleLinkedListNode<T> node, T element){
        if(node != null && node.isNil()){
            node.setData(element);
            node.setNext(new SingleLinkedListNode<>());
        }
        else{
            this.recursiveInsert(node.getNext(), element);
        }
    }

    public void remove(T element){
        if(!isEmpty() && element != null){
            if (this.getHead().getData().equals(element)) {
                this.setHead(this.getHead().getNext());
            }
            else{
                recursiveRemove(this.getHead(), element);
            }
        }
    }

    private void recursiveRemove(SingleLinkedListNode<T> node, T element){
        if(!node.isNil() && node != null){
            if(node.getData().equals(element)){
                node.setNext(node.getNext().getNext());
            }
            else{
                this.recursiveRemove(node.getNext(), element);
            }
        }
    }

    public T search(T element){
        T out = null;
        if(element != null){
            out = recursiveSearch(this.getHead(), element);
        }
        return out;
    }

    private T recursiveSearch(SingleLinkedListNode<T> node, T element){
        T out = null;
        if(node != null && !node.isNil()){
            if(node.getData().equals(element)){
                out = node.getData();
            }
            else {
                out = recursiveSearch(node.getNext(), element);
            }
        }
        return out;
    }

    public String toString() {
        return recursiveToString(this.getHead()).trim() + " NIL";
    }
    
    private String recursiveToString(SingleLinkedListNode<T> node) {
        if (node == null || node.isNil()) {
            return "";
        }
        return node.getData() + " -> " + recursiveToString(node.getNext());
    }
    public static void main(String[] args) {
        SingleLinkedListImpl s = new SingleLinkedListImpl<>();

        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.insert(4);
        
        System.out.println(s.size());
        s.remove(1);
        System.out.println(s.size());

        System.out.println(s.toString());

        System.out.println(s.search(2));
    }
}
