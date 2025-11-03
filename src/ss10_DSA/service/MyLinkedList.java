package ss10_DSA.service;

public class MyLinkedList<E> {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;


    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> newNode = new Node<>(element);


        if (size == 0) {
            head = tail = newNode;
        }

        else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        else {
            Node<E> current = getNode(index);
            Node<E> previous = current.prev;

            previous.next = newNode;
            newNode.prev = previous;
            newNode.next = current;
            current.prev = newNode;
        }

        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> current = getNode(index);

        if (current.prev == null) {
            head = current.next;
            if (head != null) head.prev = null;
        } else {
            current.prev.next = current.next;
        }

        if (current.next == null) {
            tail = current.prev;
            if (tail != null) tail.next = null;
        } else {
            current.next.prev = current.prev;
        }

        size--;
    }


    public int size() {
        return size;
    }


    private Node<E> getNode(int index) {
        Node<E> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}

