package classesandobjects;

class OverloadDemo{
    public void test(){
        System.out.println("No parameters");
    }
/* 
    public void test(int a){
        System.out.println("a: " + a);
    }
*/
    public void test(int a, int b){
        System.out.println("a and b: " + a + " " + b);
    }

    public double test(double a){
        System.out.println("double a: " + a);
        return a*a;
    }
}

class Overload{
    public static void main(String[] args){
        OverloadDemo ob = new OverloadDemo();
        double result;

        ob.test();
        ob.test(10);
        ob.test(10, 20);
        result = ob.test(123.25);
        System.out.println("Result of ob.test(123.25): " + result);

        int i = 88;
        ob.test(i);
        ob.test(123.2);
    }
}
