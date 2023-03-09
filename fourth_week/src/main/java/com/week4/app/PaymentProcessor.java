package com.week4.app;
import java.lang.IllegalArgumentException;
import java.math.BigDecimal;
import java.math.RoundingMode;

class PaymentProcessor{

  public static void processTaxExemptPurchase(Account seller, Account buyer, double purchaseAmount) throws IllegalArgumentException{
    if (purchaseAmount < 0){
      throw new IllegalArgumentException("purchase amount lesser than zero.");
    }
    buyer.setBalance(buyer.getBalance() - purchaseAmount);
    seller.setBalance(seller.getBalance() + purchaseAmount);
  }

  public static void processTaxedPurchase(Account seller, Account buyer, double purchaseAmount) throws IllegalArgumentException{
    BigDecimal bdPurchaseAmount = BigDecimal.valueOf(purchaseAmount);
    BigDecimal bdTaxAmount = new BigDecimal(1.14);
    double taxedPurchaseAmount = bdPurchaseAmount.multiply(bdTaxAmount).setScale(2,RoundingMode.HALF_EVEN).doubleValue();
    if (taxedPurchaseAmount > buyer.getBalance()){
      throw new IllegalArgumentException("Buyer balance below purchase amount.");
    }
    buyer.setBalance(buyer.getBalance() - taxedPurchaseAmount);
    seller.setBalance(seller.getBalance() + taxedPurchaseAmount);

  }

  public static void issueRefund(Account seller, Account buyer, double purchaseAmount, int percentage) throws IllegalArgumentException{
    if (purchaseAmount < 0 || percentage > 100 || percentage < 0){
      throw new IllegalArgumentException("Purchase amount too low or percentage out of bounds.");
    }
    buyer.setBalance(buyer.getBalance() - purchaseAmount * (percentage/100));
    seller.setBalance(seller.getBalance() - purchaseAmount * (percentage/100));
  }

}
