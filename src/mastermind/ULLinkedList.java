//@authors Julian Powell and Alex Csorba
package mastermind;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ULLinkedList<E> implements Cloneable, Iterable<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public ULLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    public E getFirst() {
        if (head == null) {
            throw new java.util.NoSuchElementException();
        }
        return head.data;
    }

    public E getLast() {
        if (head == null) {
            throw new java.util.NoSuchElementException();
        }
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public E removeFirst() {
        if (head == null) {
            throw new java.util.NoSuchElementException();
        }
        E temp = head.data;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return temp;
    }

    public E removeLast() {
        if (head == null) {
            throw new java.util.NoSuchElementException();
        }
        if (head.next == null) {
            return removeFirst();
        }
        Node<E> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        E temp = current.next.data;
        current.next = null;
        tail = current;
        size--;
        return temp;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public ULLinkedList<E> clone() {
        try {
            ULLinkedList<E> cloned = (ULLinkedList<E>) super.clone();
            if (head != null) {
                cloned.head = new Node<>(head.data);
                Node<E> current = head.next;
                Node<E> clonedCurrent = cloned.head;
                while (current != null) {
                    Node<E> newNode = new Node<>(current.data);
                    clonedCurrent.next = newNode;
                    clonedCurrent = newNode;
                    current = current.next;
                }
            }
            return cloned;
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null || !(otherObject instanceof ULLinkedList)) {
            return false;
        }

        ULLinkedList<E> otherList = (ULLinkedList<E>) otherObject;
        if (size != otherList.size()) {
            return false;
        }

        Node<E> thisCurrent = head;
        Node<E> otherCurrent = otherList.head;
        while (thisCurrent != null) {
            if (!thisCurrent.data.equals(otherCurrent.data)) {
                return false;
            }
            thisCurrent = thisCurrent.next;
            otherCurrent = otherCurrent.next;
        }
        return true;
    }



    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }


    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item, head);
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(E item) {
        Node<E> newNode = new Node<>(item, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            private Node<E> lastReturned = null;


            public boolean hasNext() {
                return current != null;
            }


            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E item = current.data;
                lastReturned = current;
                current = current.next;
                return item;
            }


            public void remove() {
                if (lastReturned == null) {
                    throw new IllegalStateException();
                }
                if (lastReturned == head) {
                    head = head.next;
                    size--;
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    Node<E> previous = head;
                    while (previous.next != lastReturned) {
                        previous = previous.next;
                    }
                    previous.next = lastReturned.next;
                    if (lastReturned == tail) {
                        tail = previous;
                    }
                    size--;
                }
                lastReturned = null;
            }
        };
    }
}