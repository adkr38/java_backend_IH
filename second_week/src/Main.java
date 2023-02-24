public class Main{
  public static void main(String[] args) throws Animal.WrongTerrainException, CreditCard.BalanceLimitedException {
    Animal myAnimal = new Animal(true, "air");
    myAnimal.bark();
    Animal.genericBark();
    CreditCard myCard = new CreditCard("Adrian", 500);
    CreditCard davidsCard = new CreditCard("David", 600);
    System.out.println(myCard.getId());
    System.out.println(davidsCard.getId());
    System.out.println(myCard.getClass());
  }
}
