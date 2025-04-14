package org.example;

public class TapRange implements Comparable<TapRange>{
    private final int left;
    private final int right;
    private final int index;

    public TapRange(int left, int right, int index){
        this.left = left;
        this.right = right;
        this.index = index;
    }

    public int getLeft(){
        return left;
    }

    public int getRight(){
        return right;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(TapRange o) {
        return Integer.compare(this.left, o.left);
    }

    @Override
    public String toString() {
        return "l: "+this.left+" r: "+this.right+" index: "+this.index;
    }
}
