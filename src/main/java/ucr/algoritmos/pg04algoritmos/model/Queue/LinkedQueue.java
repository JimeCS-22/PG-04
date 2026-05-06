package ucr.algoritmos.pg04algoritmos.model.Queue;

import ucr.algoritmos.pg04algoritmos.model.Node;

public class LinkedQueue<T> implements MyQueue<T> {
    private Node<T> front; //anterior
    private Node<T> rear; //posterior
    private int size; //control de elementos encolados
    public LinkedQueue() {
        front = rear = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        front = rear = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int indexOf(T element) throws QueueException {
        if (isEmpty())
            throw new QueueException("Linked Queue is empty");

        int index = 0;
        Node<T> current = front;
        while (current != null) {
            if ((current.data == null && element == null) || (current.data != null && current.data.equals(element)))
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public void enQueue(T element) throws QueueException {
        Node<T> newNode = new Node<>(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public T deQueue() throws QueueException {
        if (isEmpty())
            throw new QueueException("Linked Queue is empty");

        T removed = front.data;
        front = front.next;
        size--;

        if (front == null) // quedó vacía
            rear = null;

        return removed;
    }

    @Override
    public void enQueue(T element, Integer priority) throws QueueException {
        if (priority == null)
            throw new QueueException("Priority cannot be null");
        enQueue(element);
    }

    @Override
    public boolean contains(T element) throws QueueException {
        return indexOf(element) != -1;
    }

    @Override
    public T peek() throws QueueException {
        return front();
    }

    @Override
    public T front() throws QueueException {
        if (isEmpty())
            throw new QueueException("Linked Queue is empty");
        return front.data;
    }
}
