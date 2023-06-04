package BridgePattern;

/**
 * Here both workshops i.e. Production and Assembling are independent of each other thus we are decoupling
 */
public class Main {
    public static void main(String[] args) {
        Automobile car = new Car(new Produce(), new Assemble());
        System.out.print("car");
        car.manufacture();
    }
}

interface Automobile {
    void manufacture();
}

class Car implements Automobile {
    Workshop workshop1;
    Workshop workshop2;
    Car(Workshop ws1, Workshop ws2) {
        this.workshop1 = ws1;
        this.workshop2 = ws2;
    }
    @Override
    public void manufacture() {
        this.workshop1.work();
        System.out.print("and");
        this.workshop2.work();
    }
}

interface Workshop {
    void work();
}

class Produce implements Workshop {
    @Override
    public void work() {
        System.out.print(" is produced ");
    }
}
class Assemble implements Workshop {
    @Override
    public void work() {
        System.out.print(" is Assembled ");
    }
}