import java.util.Scanner;

public class SearchAlgorithms {

    // Linear Search Method
    public static Product linearSearch(Product[] products, int targetId) {

        // Traverse each element one by one
        for (int i = 0; i < products.length; i++) {

            // Check whether current productId matches targetId
            if (products[i].productId == targetId) {

                // Product found, return the object
                return products[i];
            }
        }

        // Product not found
        return null;
    }

    // Binary Search Method
    public static Product binarySearch(Product[] products, int targetId) {

        // Initialize left and right pointers
        int left = 0;
        int right = products.length - 1;

        // Continue until left pointer crosses right pointer
        while (left <= right) {

            // Find middle index
            int mid = (left + right) / 2;

            // If target productId is found
            if (products[mid].productId == targetId) {
                return products[mid];
            }

            // If targetId is greater, search in right half
            else if (products[mid].productId < targetId) {
                left = mid + 1;
            }

            // Otherwise search in left half
            else {
                right = mid - 1;
            }
        }

        // Product not found
        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store products in sorted order of productId
        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Bag", "Fashion")

        };

        // Get Product ID from user
        System.out.print("Enter Product ID to Search: ");
        int targetId = sc.nextInt();

        // Perform Linear Search
        Product linearResult = linearSearch(products, targetId);

        // Display Linear Search result
        if (linearResult != null) {

            System.out.println("\nLinear Search Result");
            System.out.println("Product ID   : " + linearResult.productId);
            System.out.println("Product Name : " + linearResult.productName);
            System.out.println("Category     : " + linearResult.category);

        } else {

            System.out.println("\nProduct not found using Linear Search");
        }

        // Perform Binary Search
        Product binaryResult = binarySearch(products, targetId);

        // Display Binary Search result
        if (binaryResult != null) {

            System.out.println("\nBinary Search Result");
            System.out.println("Product ID   : " + binaryResult.productId);
            System.out.println("Product Name : " + binaryResult.productName);
            System.out.println("Category     : " + binaryResult.category);

        } else {

            System.out.println("\nProduct not found using Binary Search");
        }

        sc.close();
    }
}