package org.example;

public class Queue<T> {

    private LinkNode<T> head;
    private LinkNode<T> tail;
    private int length;
    private final int maxSize;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void addElement(T element) throws Exception {
        if (this.length == maxSize){
            throw new Exception("Queue size is full");
        }
        if (element == null){
            throw new Exception("Element is null");
        }
        LinkNode<T> newNode = new LinkNode<T>(element);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.length++;
    }

    public T peek(){
        if (this.length == 0){
            return null;
        }
        return this.head.getElement();
    }

    public T remove() throws Exception{
        if (this.length == 0){
            throw new Exception("Queue is empty");
        }
        LinkNode<T> node = this.head;
        if (this.length == 1){
            this.head = null;
            this.tail = null;
        }
        else {
            this.head = this.head.getNext();
        }
        this.length--;
        return node.getElement();
    }

    public int size(){
        return this.length;
    }
}
