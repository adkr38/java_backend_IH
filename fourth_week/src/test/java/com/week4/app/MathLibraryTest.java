package com.week4.app;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;

class MathLibraryTest{
  MathLibrary math;

  
  @BeforeEach
  void setUp() throws MathLibrary.EmptyListException{
    MathLibrary math = new MathLibrary();
  }

  @Test
  @DisplayName("testSumListAddsPositiveIntegers")
  void testSumListAddsPositiveIntegers() throws MathLibrary.EmptyListException{
    ArrayList<Integer> myList = new ArrayList<Integer>(Arrays.asList(1,1));
    Assertions.assertEquals(2,math.sumList(myList));
  }

  @Test
  @DisplayName("testSumListAddsNegativeIntegers")
  void testSumListAddsNegativeIntegers() throws MathLibrary.EmptyListException{
    ArrayList<Integer> myList = new ArrayList<Integer>(Arrays.asList(-1,-1));
    Assertions.assertEquals(-2,math.sumList(myList));
  }
  
  @Test
  @DisplayName("testEmptyListifArrayListIsEmpty")
  void testEmptyListToSumIfarrayListIsEmpty() throws MathLibrary.EmptyListException{
    ArrayList<Integer> myList = new ArrayList<Integer>(Arrays.asList());
    Assertions.assertThrows(MathLibrary.EmptyListException.class,()-> math.sumList(myList));
  }
}
