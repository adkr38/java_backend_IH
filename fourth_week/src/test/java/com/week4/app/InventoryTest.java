package com.week4.app;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryTest{
  @Test
  void testGetSampleInventoryFirstInvetoryItemNameIsYougurt() {
    Inventory sampleInv = Inventory.getSampleInventory();
    assertEquals("yogurt",sampleInv.invoiceItems[0].name);
  }
}
