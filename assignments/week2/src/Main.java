import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

class Main {
  public static void main(String[] args) throws IOException ,Employee.SalaryLimitedException {
    ArrayList<Employee> employees = new ArrayList<Employee>();
    Employee Adrian = new Employee("Adrian",  22, 13000);
    Employee David = new Employee("David",  22, 33000);
    Employee Sara= new Employee("Sara",  20, 43000);
    Employee Elena= new Employee("Elena",  25, 13000);
    Employee Mireia= new Employee("Mireia",  32, 10000);
    Employee Maria= new Employee("Maria",  42, 11000);
    Employee Jose= new Employee("Jose",  55, 23000);
    Employee Miriam= new Employee("Miriam",  18, 53000);
    Employee Andres= new Employee("Andres",  19, 3000);
    Employee Daniel= new Employee("Daniel",  22, 21000);
    employees.add(Adrian);
    employees.add(David);
    employees.add(Sara);
    employees.add(Elena);
    employees.add(Mireia);
    employees.add(Maria);
    employees.add(Jose);
    employees.add(Miriam);
    employees.add(Andres);
    employees.add(Daniel);


    FileWriter writer = new FileWriter("employees.txt",true);
    writer.write("Name;Email;Age;Salary;\n");

    employees.forEach((Employee emp) -> {
      try{
        emp.writeStatsToFile(writer);
      }catch(IOException e){
        System.out.println(e);
      }
    });
      writer.close();
  }
}
