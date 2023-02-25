public class Intern extends Employee{

  static public final int SALARY_LIMIT = 20000;

  /** La excepción se ejecutaría en la clase Employee para evitar inicializar super con un salario no deseado. */
  Intern(String name,  int age, double salary) throws Employee.SalaryLimitedException{
    super(name,age,salary);
  }

}


