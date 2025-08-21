package linkedList;

public class SingleLinkedListImpl<T> extends SingleLinkedListNode<T> implements LinkedList<T> {

    private SingleLinkedListNode<T> head;

    public SingleLinkedListImpl(){
        this.head = new SingleLinkedListNode<>();
    }

    @Override
    public boolean isEmpty() {
       return this.getHead().isNil();
    }

    @Override
    public int size() {
        int size = 0;
        SingleLinkedListNode<T> aux = head;

        while(!aux.isNil()){
            size++;
            aux = aux.getNext();
        }
        return size;
    }
    //1 -> nil
    @Override
    public T search(T element) {
        T out = null;
        if(element != null && isEmpty()){
            SingleLinkedListNode<T> aux = new SingleLinkedListNode<>();

            while(!aux.isNil() && !aux.getData().equals(element)){
                aux = aux.getNext();
            }
            out = aux.getData();
        }
        return out;
    }

    @Override
    public void insert(T element) {
        if(element != null){
            SingleLinkedListNode<T> aux = getHead();
            if(this.isEmpty()){
                SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, this.getHead());
                this.setHead(newHead);
            }
            else{
                while(!aux.isNil()){
                    aux = aux.getNext();
                }
                this.data = element;
                this.next = new SingleLinkedListNode<>();
            }   
        }
    }

    @Override
    public void remove(T element) {
        if(this.getHead().getData().equals(element)){
            this.head = head.getNext();
        }
        else{
            SingleLinkedListNode<T> aux = this.getHead();
            while(!aux.isNil() && !super.getData().equals(element)){
                aux = aux.getNext();
            }
            if(!aux.isNil()){
                aux.data = aux.getNext().getData();
                aux.next = aux.getNext().getNext();
            }
        }
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[this.size()];
       SingleLinkedListNode<T> auxHead = getHead();
       int indexArray = 0;


       while(!auxHead.isNil()){
        array[indexArray++] = auxHead.getData();
        auxHead = auxHead.getNext();
       }
       return array;
    }
    
    public SingleLinkedListNode<T> getHead(){
        return head;
    }

    public void setHead(SingleLinkedListNode<T> head){
        this.head = head;
    }
}
