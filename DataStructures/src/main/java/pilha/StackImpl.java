package pilha;

public class StackImpl<T> implements Stack<T> {
    private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		this.array = (T[]) new Object[size];
		this.top = -1;
	}

    @Override
    public void push(T element) throws StackOverflowException {
        if(this.isFull()){
            throw new StackOverflowException();
        }
        if(element != null){
            this.top++;
            this.array[this.top] = element;
        }
    }

    @Override
    public T pop() throws StackUnderflowException {
        if(this.isEmpty()){
            throw new StackUnderflowException();
        }
        return this.array[this.top--];
    }

    @Override
    public T top() {
        return !isEmpty() ? this.array[this.top] : null;
    }

    @Override
    public boolean isEmpty() {
       return this.top == -1;
    }

    @Override
    public boolean isFull() {
        return this.top == this.array.length - 1;
    }

}
