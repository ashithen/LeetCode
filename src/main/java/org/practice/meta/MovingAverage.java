package org.practice.meta;

public class MovingAverage {

    private int pointer;
    private int[] arr;
    private double sum;
    private boolean isFull;

    public MovingAverage(int size) {
        this.arr = new int[size];
        this.pointer = 0;
        this.sum = 0;
        this.isFull = false;
    }

    public double next(int val) {
        if (isFull){
            this.sum -= this.arr[this.pointer];
        }
        this.arr[this.pointer] = val;
        this.pointer++;
        this.sum += val;
        if (this.pointer == this.arr.length){
            this.isFull = true;
            this.pointer = 0;
        }
        int size = isFull ? arr.length : this.pointer;
        return this.sum/size;
    }
}
