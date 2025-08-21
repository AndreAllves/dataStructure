package fila;

public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		super("Fila vazia");
	}

}