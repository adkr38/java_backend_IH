public class UtilityVehicle extends Car{
    protected boolean fourWheelDrive;

    protected UtilityVehicle(int vinNumber, String make, String model, int mileage, boolean fourWheelDrive){
      super(vinNumber,make,model,mileage);
      setFourWheelDrive(fourWheelDrive);
  }

	public boolean getFourWheelDrive() {
		return fourWheelDrive;
	}

	public void setFourWheelDrive(boolean fourWheelDrive) {
		this.fourWheelDrive = fourWheelDrive;
	}
}
