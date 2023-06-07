package CompositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite Pattern consists of three parts
 * 1. Component (Department, SalesDept., FinanceDept., HeadDepartment)
 * 2. Leaf (SalesDept. , FinanceDept.)
 * 3. Composite (HeadDepartment as it contains addDepartment method);
 */
public class Main {
    public static void main(String[] args) {
        Department salesDepartment = new SalesDepartment();
        Department financeDepartment = new FinanceDepartment();
        HeadDepartment headDepartment = new HeadDepartment();
        headDepartment.addDepartment(salesDepartment);
        headDepartment.addDepartment(financeDepartment);
        headDepartment.printDepartmentName();
    }
}

interface Department {
    void printDepartmentName();
}

class SalesDepartment implements Department {
    int id;
    String name;
    SalesDepartment() {
        this.id = 1;
        this.name = "sales department";
    }
    @Override
    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }
}

class FinanceDepartment implements Department {
    int id;
    String name;
    FinanceDepartment() {
        this.id = 1;
        this.name = "finance department";
    }
    @Override
    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }
}

class HeadDepartment implements Department {
    int id;
    String name;
    List<Department> list;
    HeadDepartment() {
        this.id = 3;
        this.name = "head department";
        this.list = new ArrayList<>();
    }
    @Override
    public void printDepartmentName() {
        list.forEach(item -> item.printDepartmentName());
    }
    public void addDepartment(Department department) {
        this.list.add(department);
    }
}
