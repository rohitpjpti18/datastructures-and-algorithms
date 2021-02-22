package classesandobjects;

class Box {
    private double width;
    private double height;
    private double depth;

    public Box(double w, double h, double d){
        this.width = w;
        this.height = h;
        this.depth = d;
    }

    public Box(){
        this.width = -1;
        this.height = -1;
        this.depth = -1;
    }

    public Box(double len){
        this.width = this.height = this.depth = len;
    }

    public double volume(){
        return this.width * this.height * this.depth;
    }
}

public class OverloadCons{
    public static void main(String[] args){
        Box mybox1 = new Box(10, 20, 15);
        Box mybox2 = new Box();
        Box mycube = new Box(7);
        double vol;

        // get volume of first box
        vol = mybox1.volume();
        System.out.println("Volume of mybox1 is " + vol);

        // get volume of second box
        vol = mybox2.volume();
        System.out.println("Volume of mybox2 is " + vol);
        
        // get volume of cube
        vol = mycube.volume();
        System.out.println("Volume of mycube is " + vol);
    }
}