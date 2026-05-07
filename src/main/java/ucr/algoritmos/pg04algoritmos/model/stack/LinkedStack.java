package ucr.algoritmos.pg04algoritmos.model.stack;

import ucr.algoritmos.pg04algoritmos.model.Node;
import util.Utility;

public class LinkedStack<T> implements MyStack<T> {
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
        if (isEmpty()) return "Linked Stack is empty";

        StringBuilder sb = new StringBuilder("TOP ➡️ ");
        try{
            LinkedStack<T> auxStack = new LinkedStack<>();

            while(!isEmpty()){

                sb.append("[").append(peek()).append("]");
                auxStack.push(pop());

                if(!isEmpty()) sb.append(" , ");
            }
            //dejamos la pila original como al inicio
            while(!auxStack.isEmpty()) push(auxStack.pop());

        }catch(StackException e){
            throw new RuntimeException(e);
        }

        sb.append("➡️ BOTTOM");
        return sb.toString();


    }
}
