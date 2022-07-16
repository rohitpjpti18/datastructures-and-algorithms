package src.array3;

public class PowFunc {
    public double helper(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        
        double res = helper(x, n/2);
        res = res*res;
        
        return n%2 == 0 ? res : x*res; 
    }
    
    public double myPow(double x, int n) {
        double result = helper(x, Math.abs(n));
        
        return n >= 0 ? result : 1/result;
    }
}
