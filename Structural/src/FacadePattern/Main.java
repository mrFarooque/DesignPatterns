package FacadePattern;

public class Main {
    public static void main(String[] args) {
        // without Facade client have to create Food instance and collect all ingredients required then prepare
        Food tea = new Tea();
        Ingredients ingredients = new Ingredients();
        tea.prepare(ingredients.getTeaIngredients());
        tea.deliver();

        // with Facade - Waiter will do all the required job for us
        Waiter waiter = new Waiter();
        waiter.takeOrder(FoodType.TEA);
    }
}

interface Food {
    void prepare(String ingredients);
    void deliver();
}

class Tea implements Food {
    String preparedItem;
    @Override
    public void prepare(String ingredients) {
        preparedItem = "Red Tea with ingredients [" + ingredients + "]";
    }

    @Override
    public void deliver() {
        System.out.println(preparedItem);
    }
}

class Ingredients {
    public String getTeaIngredients() {
        return "Water, Tea leaves, Sugar, Milk";
    }
}

class Waiter {
    Ingredients ingredients;
    Waiter() {
        ingredients = new Ingredients();
    }
    public void takeOrder(FoodType foodType) {
        switch (foodType) {
            case TEA :
                Food tea = new Tea();
                tea.prepare(ingredients.getTeaIngredients());
                tea.deliver();
                break;
            default:
                System.out.println("No Such Food Available");
        }
    }
}

enum FoodType {
    TEA
}