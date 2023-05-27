package FactoryDesignPattern;

public class AnimalFactory {
   public static Animal provideAnimal(String choice) {
      switch (choice) {
      case "FactoryDesignPattern.Dog" : return new Dog();
      case "FactoryDesignPattern.Cat" : return new Cat();
      default: return null;
      }
   }
}
