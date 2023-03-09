package com.week4.app;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;


class PaymentProcessorTest{
  private Account seller;
  private Account buyer;
  private Account buyerWithLowBalance;
  private double purchaseAmount;
  private double wrongPurchaseAmount;
  private double taxPurchaseAmount;

  @BeforeEach
  void setUp(){
    seller = new Account("Jhon", "Barcelona", 5000.51, 1132512);
    buyer = new Account("Adrian", "Barcelona", 2006.22, 2002151);
    buyerWithLowBalance = new Account("Adrian", "Barcelona", 10.13, 9932151);
    purchaseAmount= 302.15;
    wrongPurchaseAmount= -1;
    BigDecimal taxAmount = new BigDecimal(1.14);
    BigDecimal purchaseAmountBigDec = BigDecimal.valueOf(purchaseAmount);
    taxPurchaseAmount = purchaseAmountBigDec.multiply(taxAmount).setScale(2,RoundingMode.HALF_EVEN).doubleValue();
  }
  

  @Test
  @DisplayName("testProcessTaxExemptPurchaseNegativeIntegerTrhowsIllegalArgumentException")
  void testProcessTaxExemptPurchaseNegativeIntegerTrhowsIllegalArgumentException(){
    Assertions.assertThrows(IllegalArgumentException.class, () -> PaymentProcessor.processTaxExemptPurchase(seller, buyer, wrongPurchaseAmount));
  }

  @Test
  @DisplayName("testProcessTaxExemptPurchaseAddsBalanceToSeller")
  void testProcessTaxExemptPurchaseAddsBalanceToSeller(){
    double expectedBalance = seller.getBalance() + purchaseAmount;
    PaymentProcessor.processTaxExemptPurchase(seller, buyer, purchaseAmount);
    Assertions.assertEquals(expectedBalance, seller.getBalance());
  }

  @Test
  @DisplayName("testProcessTaxExemptPurchaseSubtractsBalanceFromBuyer")
  void testProcessTaxExemptPurchaseSubtractsBalanceFromBuyer(){
    double expectedBalance = buyer.getBalance() - purchaseAmount;
    PaymentProcessor.processTaxExemptPurchase(seller, buyer, purchaseAmount);
    Assertions.assertEquals(expectedBalance, buyer.getBalance());
  }

  @Test
  @DisplayName("testProcessTaxedPurchaseAmountGreaterThanBuyerBalanceThrowsIllegalArgumentException")
  void testProcessTaxedPurchaseAmountGreaterThanBuyerBalanceThrowsIllegalArgumentException(){
    Assertions.assertThrows(IllegalArgumentException.class,()-> PaymentProcessor.processTaxedPurchase(seller, buyerWithLowBalance, purchaseAmount));
  }

  @Test
  @DisplayName("testProcessTaxedPurchaseAddsBalanceToSeller")
  void testProcessTaxedPurchaseAddsBalanceToSeller(){
    double expectedSellerBalancePostTransaction = seller.getBalance() + taxPurchaseAmount;
    PaymentProcessor.processTaxedPurchase(seller, buyer, purchaseAmount);
    Assertions.assertEquals(expectedSellerBalancePostTransaction,seller.getBalance());
  }

  @Test
  @DisplayName("testProcessTaxedPurchaseSubtractsBalanceFromBuyer")
  void testProcessTaxedPurchaseSubtractsBalanceFromBuyer(){

    double expectedBuyerBalancePostTransaction = buyer.getBalance() - taxPurchaseAmount;
    PaymentProcessor.processTaxedPurchase(seller, buyer, purchaseAmount);
    Assertions.assertEquals(expectedBuyerBalancePostTransaction,buyer.getBalance());
  }
}
