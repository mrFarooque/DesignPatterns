package SingletonDesignPattern;

public class Main {
   public static void main(String[] args) {
      Student student = Student.createStudent();
      student.roll = 1; student.name="Asad";
      System.out.println(student);
      student = Student.createStudent(); // this time also you will get same student object
      System.out.println(student);
   }
}
