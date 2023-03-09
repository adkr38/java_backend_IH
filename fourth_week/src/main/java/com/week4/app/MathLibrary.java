package com.week4.app; 
import java.util.ArrayList;
import java.util.Optional;

public class MathLibrary{
  public static int sumList(ArrayList<Integer> arrayList) throws EmptyListException{
    Optional<Integer>optionalResult = arrayList.stream().reduce((a,b)->a+b);
    if (optionalResult.isPresent()){
      return optionalResult.get();
    }
    throw new EmptyListException("Unable to sum an empty list!");
  }

  public static class EmptyListException extends Exception{
    public EmptyListException(String errorMsg){
      super(errorMsg);
    }

  }

}
