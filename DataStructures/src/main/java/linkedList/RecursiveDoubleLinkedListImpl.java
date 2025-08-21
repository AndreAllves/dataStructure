package linkedList;


public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

    RecursiveDoubleLinkedListImpl<T> previous;

    public RecursiveDoubleLinkedListImpl(){
    }

    @Override
    public void insert(T element){
        if(element != null){
            if(this.isEmpty()){
                this.setData(element);
                this.setNext(new RecursiveDoubleLinkedListImpl<>());

                if(this.getPrevious() == null){
                    this.setPrevious(new RecursiveDoubleLinkedListImpl<>());
                }
            }
            else{
                this.getNext().insert(element);
            }
        }
    }

    @Override
    public void remove(T element){
        if(element != null && !isEmpty()){
            if(this.getData().equals(element)){
                if(this.getPrevious().isEmpty()){
                   this.removeFirst();
                }
                if(this.getNext().isEmpty()){
                    this.removeLast();
                }

                else{
                    this.getPrevious().setNext(this.getNext());
                    ((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this.getPrevious());
                }
            }
            else{
                this.getNext().remove(element);
            }
        }
    }

    @Override
    public void insertFirst(T element) {
       if(element != null){
        if(isEmpty()){
            this.insert(element);
        }
        else{
            RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>();
            newNode.setData(this.getData());
            this.data = element;
            newNode.setNext(this.getNext());
            this.next = newNode;
            newNode.setPrevious(this);
            ((RecursiveDoubleLinkedListImpl<T>) this.getPrevious()).setPrevious(newNode);
        }
       }
    }

    @Override
    public void removeFirst() {
        if(!this.isEmpty()){
            if(this.next.isEmpty() && this.previous.isEmpty()){
                this.data = null;
                this.next = null;
                this.previous = null;
            }
            else{
                this.data = this.next.getData();
                this.next = this.next.getNext();
                ((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
            }
        }
    }

    @Override
    public void removeLast() {
       if(!this.isEmpty()){
        if(this.getNext().isEmpty()){
            this.data = null;
            this.next = null;

            if(this.previous.isEmpty()){
                this.previous = null;
            }
        }
        else{
            ((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
        }
       }
    }

    public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}  
}