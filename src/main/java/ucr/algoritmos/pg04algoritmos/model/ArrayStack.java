package ucr.algoritmos.pg04algoritmos.model;

import util.Utility;

public class ArrayStack<T> implements MyStack<T> {

    private int n; //el tam max de la pila
    private int top; //para llevar el control del tope de la pila
    private T[] data; //arreglo para guardar los elementos de la pila

    public ArrayStack(int n) {
        if(n<=0) System.exit(1); //se sale
        this.n = n;
        this.top = -1;
        this.data = (T[]) new Object[n];
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public void clear() {
        this.data = (T[]) new Object[n];
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    @Override
    public T peek() throws StackException {
        return null;
    }

    @Override
    public T top() throws StackException {
        if (isEmpty())
            throw new StackException("Array Stack is empty");
        return data[top];
    }

    @Override
    public void push(T element) throws StackException {
        if(top==n-1)
            throw new StackException("Array Stack is full");
        data[++top] = element;
    }

    @Override
    public T pop() throws StackException {
        return null;
    }
/*
    @Override
    public String toString() {
        if (isEmpty())
            return "Array Stack is empty";

        StringBuilder result = new StringBuilder("Array Stack Content:\n");
        String instance = Utility.instanceOf(data[0], data[0]);
        boolean isClass = !instance.equals("Integer") && !instance.equals("Double") && !instance.equals("Character") && !instance.equals("String");

        try {
            ArrayStack<T> aux = new ArrayStack<T>(size());
            while (!isEmpty()) { //desapilar
                result.append(peek()).append(isClass? "\n" : " ");
                aux.push(pop());
            }
            while (!aux.isEmpty()) //volver a apilar
                push(aux.pop());
        } catch (StackException e) {
            throw new RuntimeException(e);
        }

        return result.toString();
    }*/
}
