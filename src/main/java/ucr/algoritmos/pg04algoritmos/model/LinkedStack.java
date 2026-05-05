package ucr.algoritmos.pg04algoritmos.model;

import jdk.jshell.execution.Util;
import util.Utility;

public class LinkedStack<T> implements MyStack<T>  {
    private Node<T> top; //es un apuntador
    private int size; //elementos apilados

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T peek() throws StackException {
        return top();
    }

    @Override
    public T top() throws StackException {
        if (isEmpty())
            throw new StackException("Linked Stack is empty");
        return top.data;
    }

    @Override
    public void push(T element) throws StackException {
        Node<T> newNode = new Node<T>(element);
        if (!isEmpty())
            newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public T pop() throws StackException {
        if(isEmpty())
            throw new StackException("Linked Stack is empty");
        T popped = top.data;
        top = top.next;
        size--;
        return popped;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Stack is empty";

        StringBuilder result = new StringBuilder("Linked Stack Content:\n");
        String instance = Utility.instanceOf(top.data, top.data);
        boolean isClass = !instance.equals("Integer") && !instance.equals("Double") && !instance.equals("Character") && !instance.equals("String");

        try {
            LinkedStack<T> aux = new LinkedStack<T>();
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
    }
}
