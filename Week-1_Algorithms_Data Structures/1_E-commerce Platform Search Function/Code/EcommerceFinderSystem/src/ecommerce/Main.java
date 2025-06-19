package ecommerce;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P101", "Laptop", "Electronics"),
            new Product("P102", "Shoes", "Footwear"),
            new Product("P103", "Keyboard", "Electronics"),
            new Product("P104", "Book", "Education")
        };

        System.out.println("=== Linear Search ===");
        Product p1 = SearchEngine.linearSearch(products, "Keyboard");
        System.out.println(p1 != null ? "Found: " + p1 : "Not found");

        System.out.println("\n=== Binary Search ===");
        SearchEngine.sortByName(products); // Required for binary search
        Product p2 = SearchEngine.binarySearch(products, "Keyboard");
        System.out.println(p2 != null ? "Found: " + p2 : "Not found");
    }
}
