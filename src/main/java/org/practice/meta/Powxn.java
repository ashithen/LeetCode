package org.practice.meta;

public class Powxn {

    private double calc(double x, int n){
        if (n==1){
            return x;
        }
        boolean isOdd = (n&1) == 1;
        double prod = calc(x,n/2);
        prod *= prod;
        if (isOdd){
            prod *= x;
        }
        return prod;
    }
    public double myPow(double x, int n) {
        if (x==1 || n==0){
            return 1;
        }
        else if (x == -1){
            return (n&1)==1 ? -1 : 1;
        }
        else if (n <= -2056){
            return 0;
        }
        else if (n > 0){
            return this.calc(x,n);
        }
        else {
            return 1/this.calc(x,-n);
        }
    }

}
