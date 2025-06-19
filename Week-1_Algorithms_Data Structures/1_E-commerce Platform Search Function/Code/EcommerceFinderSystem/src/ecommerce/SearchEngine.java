package ecommerce;

import java.util.Arrays;
import java.util.Comparator;

public class SearchEngine {

    public static Product linearSearch(Product[] arr, String name) {
        for (Product p : arr) {
            if (p.getProductName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] arr, String name) {
        // Binary Search assumes array is sorted by name
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].getProductName().compareToIgnoreCase(name);
            if (cmp == 0) return arr[mid];
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void sortByName(Product[] arr) {
        Arrays.sort(arr, Comparator.comparing(Product::getProductName));
    }
}
