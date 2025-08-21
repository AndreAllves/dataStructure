package linkedList;

import java.util.Objects;

public class SingleLinkedListNode<T> {
    protected T data;
    protected SingleLinkedListNode<T> next;

    public SingleLinkedListNode(T data, SingleLinkedListNode<T> next){
        this.data = data;
        this.next = next;
    }

    public SingleLinkedListNode(){
    }

    public boolean isNil(){
        return this.data == null;
    }

    public T getData(){
        return data;
    }

    public SingleLinkedListNode<T> getNext(){
        return next;
    }

    @Override
    public String toString() {
        String out = isNil() ? "NIL" : this.data.toString();
        return out;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleLinkedListNode<?> that = (SingleLinkedListNode<?>) o;
        return Objects.equals(data, that.data);
    }


    public void setData(T data){
        this.data = data;
    }

    public void setNext(SingleLinkedListNode<T> next){
        this.next = next;
    }
}