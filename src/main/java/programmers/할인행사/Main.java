package programmers.할인행사;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public int solution(String[] want, int[] number, String[] discount) {
    int count = 0;

    Map<String, Integer> wants = new HashMap<>();
    for (int i = 0; i < want.length; i++) {
      wants.put(want[i], number[i]);
    }

    Map<String, Integer> currentDiscounts = new HashMap<>();

    for (int i = 0; i < 10; i++) {
      String currentProduct = discount[i];
      currentDiscounts.put(currentProduct, currentDiscounts.getOrDefault(currentProduct, 0) + 1);
    }

    if (match(wants, currentDiscounts)) {
      count++;
    }

    for (int i = 10; i < discount.length; i++) {
      String removeProduct = discount[i - 10];
      if (currentDiscounts.get(removeProduct) == 1) {
        currentDiscounts.remove(removeProduct);
      } else {
        currentDiscounts.put(removeProduct, currentDiscounts.get(removeProduct) - 1);
      }

      String addProduct = discount[i];
      currentDiscounts.put(addProduct, currentDiscounts.getOrDefault(addProduct, 0) + 1);

      if (match(wants, currentDiscounts)) {
        count++;
      }
    }

    return count;
  }

  private boolean match(Map<String, Integer> wants, Map<String, Integer> currentDiscounts) {
    for (String product : wants.keySet()) {
      Integer wantStock = wants.get(product);
      Integer discountStock = currentDiscounts.get(product);
      if (!currentDiscounts.containsKey(product) || !wantStock.equals(discountStock)) {
        return false;
      }
    }
    return true;
  }
}