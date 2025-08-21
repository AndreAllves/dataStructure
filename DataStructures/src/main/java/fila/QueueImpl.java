package fila;

public class QueueImpl<T> implements Queue<T> {
	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		this.array = (T[]) new Object[size];
		this.tail = -1;
	}

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if(isFull()){
            throw new QueueOverflowException();
        }

        if(element != null){
            this.tail++;
            this.array[tail] = element;
        }
    }

    private void shiftLeft(){
        for(int i = 0; i < this.tail; i++){
            this.array[i] = this.array[i+1];
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        
        T removed = this.array[0];
        shiftLeft();
        tail--;
        
        return removed;
    }

    @Override
    public T head() {
        return !isEmpty() ? this.array[0] : null;
    }

    @Override
    public boolean isEmpty() {
       return this.tail == -1;
    }

    @Override
    public boolean isFull() {
        return this.tail == array.length - 1;
    }
    
}
