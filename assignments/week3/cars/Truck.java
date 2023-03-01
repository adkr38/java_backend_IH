class Truck extends Car{
  protected double towingCapacity;

  Truck(int vinNumber, String make,String model, int mileage, double towingCapacity){
    super(vinNumber,make,model,mileage);
    setTowingCapacity(towingCapacity);
  }

  public double getTowingCapacity() {
    return towingCapacity;
  }

  public void setTowingCapacity(double towingCapacity) {
    this.towingCapacity = towingCapacity;
  }


}
