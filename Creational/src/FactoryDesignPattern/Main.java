package FactoryDesignPattern;

public class Main {
   public static void main(String[] args) {
      Animal animal;
      animal = AnimalFactory.provideAnimal("FactoryDesignPattern.Dog");
      System.out.println(animal.makeSound());
      animal = AnimalFactory.provideAnimal("FactoryDesignPattern.Cat");
      System.out.println(animal.makeSound());
   }
}