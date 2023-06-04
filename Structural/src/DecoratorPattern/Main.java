package DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        Tea tea = new RedTea();
        orderSummary(tea);
        tea = new Ginger(new RedTea());
        orderSummary(tea);
        tea = new Lemon(new Ginger(new RedTea()));
        orderSummary(tea);
    }
    public static void orderSummary(Tea tea) {
        System.out.println("Your order is : " + tea.description() + " and cost is : Rs."+ tea.cost());
    }
}

interface Tea {
    String description();
    int cost();
}

class RedTea implements Tea {
    @Override
    public String description() {
        return "Red Tea";
    }

    @Override
    public int cost() {
        return 10;
    }
}

abstract class TeaDecorator implements Tea{
    Tea tea;
    TeaDecorator(Tea tea) {
        this.tea = tea;
    }
}

class Ginger extends TeaDecorator {

    Ginger(Tea tea) {
        super(tea);
    }

    @Override
    public String description() {
        return tea.description() + " with Ginger";
    }

    @Override
    public int cost() {
        return tea.cost() + 2;
    }
}

class Lemon extends TeaDecorator {
    Lemon(Tea tea) {
        super(tea);
    }

    @Override
    public String description() {
        return tea.description() + " with Lemon";
    }

    @Override
    public int cost() {
        return tea.cost() + 1;
    }
}