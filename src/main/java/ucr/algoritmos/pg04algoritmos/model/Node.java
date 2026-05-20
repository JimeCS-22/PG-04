package ucr.algoritmos.pg04algoritmos.model;

public class Node<T> {

    public T data;
    public Node<T> next; //apuntador al nodo siguiente
    public Node<T> prev;//apuntador al nodo siguiente
    public Integer priority;// 1-Alta,2-media y 3-baja

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = null;//Por default que apunta a nulo
        this.prev = null;
    }

    public Node(T data) {
        this.data = data;
    }

    public Node() {
        this.data = null;
        this.next = null;
        this.next = this.prev = null;
    }

    public Node(T element, Integer priority) {

        this.data = element;
        this.priority = priority;
        this.next = null;

    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    //esta clase es para llenar de una mejor manera la tabla de Linked List
    public static class NodeInfo {
        private String posicion;
        private final String valor;
        private final String referencia;

        public NodeInfo(String posicion, String valor, String referencia) {
            this.posicion = posicion;
            this.valor = valor;
            this.referencia = referencia;
        }

        public String getPosicion() {
            return posicion;
        }

        public String getValor() {
            return valor;
        }

        public String getReferencia() {
            return referencia;
        }

        //for the table
        public void setPosicion(String posicion) {
            this.posicion = posicion;
        }
    }

    //Para el nodo circular PG-04
    public static class CircularNodeData {

        private int indexOf;
        private int data;
        private int nextData;
        private int prevData;
        private int headData;
        private int tailData;

        public CircularNodeData() {
        }

        public CircularNodeData(int indexOf, int data, int nextData,
                                int prevData, int headData, int tailData) {

            this.indexOf = indexOf;
            this.data = data;
            this.nextData = nextData;
            this.prevData = prevData;
            this.headData = headData;
            this.tailData = tailData;
        }

        public int getIndexOf() {
            return indexOf;
        }

        public void setIndexOf(int indexOf) {
            this.indexOf = indexOf;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getNextData() {
            return nextData;
        }

        public void setNextData(int nextData) {
            this.nextData = nextData;
        }

        public int getPrevData() {
            return prevData;
        }

        public void setPrevData(int prevData) {
            this.prevData = prevData;
        }

        public int getHeadData() {
            return headData;
        }

        public void setHeadData(int headData) {
            this.headData = headData;
        }

        public int getTailData() {
            return tailData;
        }

        public void setTailData(int tailData) {
            this.tailData = tailData;
        }

    }
}
