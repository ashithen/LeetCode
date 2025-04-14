package org.practice.daily_challenge;

import java.util.Objects;

public class TestQueue {
    public void addElement(int maxSize, String e) throws Exception {
        Queue<String> queue = new Queue<>(maxSize);
        queue.addElement(e);
        System.out.println(Objects.equals(queue.peek(), e));
    }

    public void addMultipleElements(int maxSize, String[] elements) throws Exception {
        Queue<String> queue = new Queue<>(maxSize);
        for (String element: elements){
            queue.addElement(element);
        }
        System.out.println(queue.size() == elements.length);
        System.out.println(Objects.equals(queue.peek(), elements[0]));
    }

    public void removeElementCase1(int maxSize, String element) throws Exception{
        Queue<String> queue = new Queue<>(maxSize);
        queue.addElement(element);
        System.out.println(Objects.equals(queue.remove(), element));
    }

    public void removeMultipleElememts(int maxSize, String[] elements) throws Exception{
        Queue<String> queue = new Queue<>(maxSize);
        for (String e : elements){
            queue.addElement(e);
        }

        for (String e : elements){
            System.out.println(Objects.equals(queue.remove(), e));
        }
    }
    public static void main(String[] args) throws Exception {
        TestQueue testQueue = new TestQueue();
        testQueue.addElement(10, "first");

        String[] elems = {"a","b","c","d","e"};
        testQueue.addMultipleElements(10, elems);

        testQueue.removeElementCase1(10,"a");
        testQueue.removeMultipleElememts(10, elems);
    }

}
