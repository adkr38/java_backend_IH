class Main{
  public static void main(String[] args) {
    IntArrayList myInts = new IntArrayList(); 
    for (int i =0; i<40;i++){
      myInts.add(i+1);
    }

    System.out.println(myInts.get(10));

    IntVector myIntsInAVector = new IntVector();
    System.out.println("This is an IntVector, I'll get the 20th element after adding some numbers.");
    for (int i =0; i<40;i++){
      myIntsInAVector.add(i+1);
    }
    System.out.println(myIntsInAVector.get(20));
    
  }
}
