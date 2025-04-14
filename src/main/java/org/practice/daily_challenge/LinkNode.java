package org.practice.daily_challenge;

public class LinkNode<T> {
    private final T element;
    private LinkNode<T> next;

    public LinkNode(T element){
        this.element = element;
    }

    public void setNext(LinkNode<T> next){
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public LinkNode<T> getNext() {
        return next;
    }
}
