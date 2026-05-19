package ucr.algoritmos.pg04algoritmos.PracticaExamen;

import ucr.algoritmos.pg04algoritmos.model.Node;
import ucr.algoritmos.pg04algoritmos.model.linkedList.CircularLinkedList;
import ucr.algoritmos.pg04algoritmos.model.linkedList.DoublyLinkedList;
import ucr.algoritmos.pg04algoritmos.model.linkedList.ListException;
import ucr.algoritmos.pg04algoritmos.model.Queue.LinkedQueue;
import ucr.algoritmos.pg04algoritmos.model.Queue.ArrayQueue;
import ucr.algoritmos.pg04algoritmos.model.Queue.QueueException;
import ucr.algoritmos.pg04algoritmos.model.stack.ArrayStack;
import ucr.algoritmos.pg04algoritmos.model.stack.StackException;

public class EjerciciosPractica {

    // Ejercicio 1: Recorrer N elementos de una lista circular (puede ser de cualquier tipo)
    public static <T> void recorrerN(CircularLinkedList<T> lista, int n) throws ListException {
        if (lista.isEmpty() || n <= 0) return;
        Node<T> actual = lista.getHead();
        for (int i = 0; i < n; i++) {
            System.out.print(actual.data + " ");
            actual = actual.next; // Por ser circular, nunca llega a null
        }
        System.out.println();
    }

    // Ejercicio 2: Balanceo de expresiones con ArrayStack<Character>
    public static boolean isBalanced(String expr) {
        ArrayStack<Character> stack = new ArrayStack<>(expr.length());
        try {
            for (int i = 0; i < expr.length(); i++) {
                char c = expr.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')' || c == ']' || c == '}') {
                    if (stack.isEmpty()) return false;
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                            (c == ']' && top != '[') ||
                            (c == '}' && top != '{')) {
                        return false;
                    }
                }
            }
        } catch (StackException e) {
            return false;
        }
        return stack.isEmpty();
    }

    // Ejercicio 3: Intercalar dos colas (q1: LinkedQueue, q2: ArrayQueue) en una nueva LinkedQueue
    public static <T> LinkedQueue<T> intercalar(LinkedQueue<T> q1, ArrayQueue<T> q2) throws QueueException {
        LinkedQueue<T> nueva = new LinkedQueue<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            nueva.enQueue(q1.deQueue());
            nueva.enQueue(q2.deQueue());
        }
        while (!q1.isEmpty()) {
            nueva.enQueue(q1.deQueue());
        }
        while (!q2.isEmpty()) {
            nueva.enQueue(q2.deQueue());
        }
        return nueva;
    }

    /**
     * A) Listas Enlazadas Circulares
     */
    //Imprimir elementos de un lista doblemente enlazada con pos
    public static <T> void imprimirDesde(CircularLinkedList<T> lista, int pos, int n) throws ListException {
        if (lista.isEmpty() || n <= 0) return;

        int size = lista.size();
        // Ajustar posición si está fuera de rango
        int startIndex = ((pos - 1) % size + size) % size;  // así funciona también para negativos o pos > size

        // Moverse al nodo de inicio
        Node<T> actual = lista.getHead();
        for (int i = 0; i < startIndex; i++) {
            actual = actual.next;
        }

        // Imprimir n elementos desde ahí
        for (int i = 0; i < n; i++) {
            System.out.print(actual.data + " ");
            actual = actual.next;
        }
        System.out.println();
    }

    //Buscar un elemento recursivamente con Listas enlazadas que ya exista
    public static <T> boolean contiene(CircularLinkedList<T> lista, T elemento) throws ListException {
        if (lista.isEmpty()) return false;
        return contieneAux(lista.getHead(), elemento, lista.getHead());
    }

    private static <T> boolean contieneAux(Node<T> actual, T elemento, Node<T> head) {
        if (actual == null) return false;
        if (actual.data.equals(elemento)) return true;
        // Si volvimos al inicio, detenemos
        if (actual.next == head) return false;
        return contieneAux(actual.next, elemento, head);
    }


    /**
     * B) Pilas
     */
    //Invertir una pila usando otra pila
    public static <T> ArrayStack<T> invertirPila(ArrayStack<T> stack) throws StackException {
        ArrayStack<T> nueva = new ArrayStack<>(stack.size());
        ArrayStack<T> aux = new ArrayStack<>(stack.size());
        // Vacío stack en aux
        while (!stack.isEmpty()) aux.push(stack.pop());
        // Vacío aux en nueva (ya invertido)
        while (!aux.isEmpty()) {
            T val = aux.pop();
            nueva.push(val);
            stack.push(val); // Restaura stack original, si quieres
        }
        return nueva;
    }

    //Validar paréntesis (solos)
    public static boolean parBalanceados(String expr) {
        int count = 0;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(') count++;
            if (c == ')') {
                count--;
                if (count < 0) return false; // Cierra un paréntesis sin abrir
            }
        }
        return count == 0;
    }

    /**
     * C) Colas
     */
    //Simulación de turnos
    public static void atencionCola(ArrayQueue<String> cola) throws QueueException {
        int orden = 1;
        while (!cola.isEmpty()) {
            String nombre = cola.deQueue();
            System.out.println("Atendiendo (" + orden + "): " + nombre);
            orden++;
        }
        System.out.println("Personas restantes en la cola: " + cola.size());
    }

    //Pasar elementos de cola a pila (manteniendo el orden)
    public static <T> void pasarColaAPila(ArrayQueue<T> q, ArrayStack<T> s) throws QueueException, StackException {
        ArrayQueue<T> aux = new ArrayQueue<>(q.size());
        // Desencolamos y ponemos en aux, también en pila (invierte orden)
        while (!q.isEmpty()) {
            T elem = q.deQueue();
            aux.enQueue(elem);
            s.push(elem);
        }
        // Restaurar la cola a su forma original
        while (!aux.isEmpty()) q.enQueue(aux.deQueue());
    }

    /**
     * D) Intercalado y fusión
     */
    //Intercalar dos pilas alternadamente en una cola
    public static <T> LinkedQueue<T> intercalarPilas(ArrayStack<T> s1, ArrayStack<T> s2) throws StackException, QueueException {
        LinkedQueue<T> resultado = new LinkedQueue<>();
        while (!s1.isEmpty() && !s2.isEmpty()) {
            resultado.enQueue(s1.pop());
            resultado.enQueue(s2.pop());
        }
        while (!s1.isEmpty()) resultado.enQueue(s1.pop());
        while (!s2.isEmpty()) resultado.enQueue(s2.pop());
        return resultado;
    }

    //Fusión ordenada de dos listas circulares (sin repetidos)
    public static <T extends Comparable<T>> CircularLinkedList<T> fusionarListasOrdenadas(CircularLinkedList<T> l1, CircularLinkedList<T> l2) throws ListException {
        CircularLinkedList<T> resultado = new CircularLinkedList<>();
        if (l1.isEmpty() && l2.isEmpty()) return resultado;

        Node<T> n1 = l1.getHead();
        Node<T> n2 = l2.getHead();
        int size1 = l1.size();
        int size2 = l2.size();
        int i = 0, j = 0;
        T lastAdded = null;

        while (i < size1 || j < size2) {
            T val1 = (i < size1) ? n1.data : null;
            T val2 = (j < size2) ? n2.data : null;
            T toAdd = null;

            if (val1 != null && (val2 == null || val1.compareTo(val2) < 0)) {
                toAdd = val1; i++; n1 = n1.next;
            } else if (val2 != null && (val1 == null || val2.compareTo(val1) < 0)) {
                toAdd = val2; j++; n2 = n2.next;
            } else if (val1 != null) { // son iguales
                toAdd = val1;
                i++; j++; n1 = n1.next; n2 = n2.next;
            }

            if (toAdd != null && (lastAdded == null || !toAdd.equals(lastAdded))) {
                resultado.add(toAdd);
                lastAdded = toAdd;
            }
        }
        return resultado;
    }

    /**
     * E) Recursividad
     */
    //Sumar los elementos de una lista (recursivo)
    public static int sumar(CircularLinkedList<Integer> lista) throws ListException {
        if (lista.isEmpty()) return 0;
        return sumarAux(lista.getHead(), lista.getHead());
    }

    private static int sumarAux(Node<Integer> actual, Node<Integer> head) {
        if (actual == null) return 0; // por seguridad
        if (actual.next == head) return actual.data; // último nodo
        return actual.data + sumarAux(actual.next, head);
    }

    /**
     * F) Listas dobles / búsqueda
     */
    //Buscar y eliminar en lista doblemente enlazada solo primera ocurrencia
    public static <T> void eliminarSiExiste(DoublyLinkedList<T> lista, T elem) throws ListException {
        if (lista.isEmpty()) return;
        Node<T> actual = lista.getHead();
        while (actual != null) {
            if (actual.data.equals(elem)) {
                // Si es el head
                if (actual == lista.getHead()) {
                    lista.setHead(actual.next);
                    if (lista.getHead() != null) lista.getHead().prev = null;
                    else lista.setTail(null);
                }
                // Si es el tail
                else if (actual == lista.getTail()) {
                    lista.setTail(actual.prev);
                    if (lista.getTail() != null) lista.getTail().next = null;
                }
                // Nodo intermedio
                else {
                    actual.prev.next = actual.next;
                    actual.next.prev = actual.prev;
                }
                break; // Solo elimina la primera ocurrencia
            }
            actual = actual.next;
        }
    }

    /**
     * Otros ejercicios
     */
    //1. Buscar elemento en lista circular (no recursivo)
    public static <T> boolean buscarElemento(CircularLinkedList<T> lista, T elem) throws ListException {
        if (lista.isEmpty()) return false;
        Node<T> actual = lista.getHead();
        int size = lista.size();
        for (int i = 0; i < size; i++) {
            if (actual.data.equals(elem)) return true;
            actual = actual.next;
        }
        return false;
    }

    //2. Contar cuántos elementos mayores que X hay en una pila
    public static int contarMayores(ArrayStack<Integer> pila, int x) throws StackException {
        ArrayStack<Integer> aux = new ArrayStack<>(pila.size());
        int count = 0;
        while (!pila.isEmpty()) {
            int val = pila.pop();
            if (val > x) count++;
            aux.push(val);
        }
        // Restaurar pila original
        while (!aux.isEmpty()) pila.push(aux.pop());
        return count;
    }

    //3. Duplicar el contenido de una cola (en el mismo orden)
    public static <T> void duplicarCola(ArrayQueue<T> q) throws QueueException {
        ArrayQueue<T> aux = new ArrayQueue<>(q.size() * 2);
        int size = q.size();
        for (int i = 0; i < size; i++) {
            T elem = q.deQueue();
            aux.enQueue(elem);
            aux.enQueue(elem); // duplicado
        }
        // restaurar cola original
        while (!aux.isEmpty()) q.enQueue(aux.deQueue());
    }

    //4. Imprimir los elementos de una pila sin perderlos de arriba hacia abajo
    public static <T> void imprimirPila(ArrayStack<T> pila) throws StackException {
        ArrayStack<T> aux = new ArrayStack<>(pila.size());
        while (!pila.isEmpty()) {
            T val = pila.pop();
            System.out.print(val + " ");
            aux.push(val);
        }
        System.out.println();
        // restaurar la pila
        while (!aux.isEmpty()) pila.push(aux.pop());
    }

    //5. Sumar todos los elementos de una lista circular
    public static int sumarLista(CircularLinkedList<Integer> lista) throws ListException {
        if (lista.isEmpty()) return 0;
        Node<Integer> actual = lista.getHead();
        int size = lista.size();
        int suma = 0;
        for (int i = 0; i < size; i++) {
            suma += actual.data;
            actual = actual.next;
        }
        return suma;
    }

    //6. Eliminar todas las ocurrencias de un elemento de una cola
    public static <T> void eliminarOcurrencias(ArrayQueue<T> cola, T elem) throws QueueException {
        ArrayQueue<T> aux = new ArrayQueue<>(cola.size());
        while (!cola.isEmpty()) {
            T dato = cola.deQueue();
            if (!dato.equals(elem)) {
                aux.enQueue(dato);
            }
        }
        while (!aux.isEmpty()) cola.enQueue(aux.deQueue());
    }

    //7. Clonar una lista circular
    public static <T> CircularLinkedList<T> clonar(CircularLinkedList<T> lista) throws ListException {
        CircularLinkedList<T> nueva = new CircularLinkedList<>();
        if (lista.isEmpty()) return nueva;
        Node<T> actual = lista.getHead();
        int size = lista.size();
        for (int i = 0; i < size; i++) {
            nueva.add(actual.data);
            actual = actual.next;
        }
        return nueva;
    }

}