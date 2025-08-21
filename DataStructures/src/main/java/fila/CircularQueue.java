package fila;

public class CircularQueue<T> implements Queue<T> {
    private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		this.array = (T[]) new Object[size];
		this.head = -1;
		this.tail = -1;
		this.elements = 0;
	}


    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if(isFull()){
            throw new QueueOverflowException();
        }
        if(element != null){
            if(isEmpty()){
                this.head = 0;
                this.tail = 0;
                this.array[0] = element;
            }
            else{
                this.tail = (this.tail + 1) % this.array.length;
                this.array[this.tail] = element;
            }
            this.elements++;
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
      if(isEmpty()){
        throw new QueueUnderflowException();
      }
      T removed = this.array[this.head];
      if(this.tail == this.head){
        this.tail = -1;
        this.head = -1;
      }
      else{
        this.head = (this.head + 1) % this.array.length;
      }
      this.elements--;
      return removed;
    }

    @Override
    public T head() {
        return !isEmpty() ? this.array[head] : null;
    }

    @Override
    public boolean isEmpty() {
        return this.elements == 0;
    }

    @Override
    public boolean isFull() {
       return this.elements == this.array.length-1;
    }
}
