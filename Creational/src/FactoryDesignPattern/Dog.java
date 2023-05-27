package FactoryDesignPattern;

public class Dog implements Animal{
   @Override
   public String makeSound() {
      return "Woof! Woof! Woof!";
   }
}
