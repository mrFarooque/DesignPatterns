package SingletonDesignPattern;

public class Student {
   public int roll;
   public String name;

   // made a static instance already which will be defined in createStudent()
   private static Student student = null;

   private Student() {
      // made default constructor private so that no one call it and create object outside this class
   }

   // but to create object outside this call, make public function which will help you to create object
   public static Student createStudent() {
      if (student == null) {
         student = new Student();
      }
      return student;
   }

   @Override
   public String toString() {
      return "Student: [name: "+ this.name +" roll: " + this.roll + "]";
   }
}
