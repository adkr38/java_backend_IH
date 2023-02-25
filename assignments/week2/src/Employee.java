import java.io.IOException;
import java.io.FileWriter;

public class Employee{
  private String name;
  private String email;
  private int age;
  private double salary;

  protected Employee(String name, int age, double salary ) throws SalaryLimitedException{
    setName(name);
    setEmail(name);
    setAge(age);
    setSalary(salary);
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String name) {
    this.email = String.format("%s@miEmpresa.com",name);
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setSalary(double salary) throws SalaryLimitedException {
    if (this instanceof Intern){
      if (salary >= Intern.SALARY_LIMIT){
        throw new SalaryLimitedException(String.format("Salary limited reached for intern; current limit: %d",Intern.SALARY_LIMIT));
      }
    }
    this.salary = salary;
  }

  public double getSalary() {
    return salary;
  }

  public void writeStatsToFile(FileWriter writer) throws IOException{
      try{

      writer.write(String.format("%s;%s;%d;%.2f;\n",name,email,age,salary));
      }catch(IOException e){
        System.out.println(e);
      }
  }

  public class SalaryLimitedException extends Exception{
    SalaryLimitedException(String errorMsg){
      super(errorMsg);
    }
  }


}
