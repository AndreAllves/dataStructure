package linkedList;

import java.util.Arrays;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {
    protected T data;
    protected RecursiveSingleLinkedListImpl<T> next;

    @Override
    public boolean isEmpty() {
        return this.data == null;
    }

    @Override
    public int size() {
        int size = 0;

        if(!this.isEmpty()){
            size = 1 + this.getNext().size();
        }

        return size;
    }

    @Override
    public T search(T element) {
        T found = null;
        
        if(element != null && !this.isEmpty()){
            found = this.getData().equals(element) ? this.getData() : this.getNext().search(element);
        }
        return found;
    }

    @Override
    public void insert(T element) {
        if(element != null){
            if(isEmpty()){
                this.data = element;
                this.next = new RecursiveSingleLinkedListImpl<>();
            }
            else{
                this.getNext().insert(element);
            }
        }
    }

    @Override
    public void remove(T element) {
        if(element != null){
            if(!isEmpty()){
                if(this.getData().equals(element)){
                    this.setData(this.getNext().getData());
                    this.setNext(this.getNext().getNext());
                }
                else{
                    this.getNext().remove(element);
                }
            }
        }
    }

    public void removeArt(int pos){
        if(!isEmpty() && pos >= 0){
            if(pos == 0){
                this.data = this.getNext().getData();
                this.next = this.getNext().getNext();
            }
            else{
                this.getNext().removeArt(pos-1);
            }
        }
    }

    public void insertArt(T element, int pos){
        if(element != null && pos >= 0){
            if(pos == 0){
                if(isEmpty()){
                    this.data = element;
                    this.next = new RecursiveSingleLinkedListImpl<>();
                }
                else{
                    RecursiveSingleLinkedListImpl<T> newNode = new RecursiveSingleLinkedListImpl();
                    newNode.data = this.data;
                    newNode.next = this.next;
                    this.data = element;
                    this.next = newNode;
                }
            }
            else{
                this.getNext().insertArt(element, pos-1);
            }
        }
    }

    public void removeNumPares(){
        if(!isEmpty()){
            if((Integer) this.getData() % 2 == 0){
                if(this.getNext() != null){
                    this.data = this.getNext().getData();
                    this.next = this.getNext().getNext();
                    removeNumPares();
                }
                else{
                    this.data = null;
                    this.next = null;
                }
            }
            else{
                this.getNext().removeNumPares();
            }
        }
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[this.size()];
        this.array(array, 0);
        return array;
    }

    private void array(T[] array, int i){
        if(!this.isEmpty()){
            array[i] = this.data;
            this.next.array(array, i+1);
        }
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public RecursiveSingleLinkedListImpl<T> getNext(){
        return next;
    }

    public void setNext(RecursiveSingleLinkedListImpl<T> next){
        this.next = next;
    }

    public static void main(String[] args) {
        RecursiveSingleLinkedListImpl s = new RecursiveSingleLinkedListImpl<>();
        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.insert(4);
        s.insert(5);
        s.insert(6);

        System.out.println(Arrays.toString(s.toArray()));
        s.removeNumPares();
        System.out.println(Arrays.toString(s.toArray()));


    }
}