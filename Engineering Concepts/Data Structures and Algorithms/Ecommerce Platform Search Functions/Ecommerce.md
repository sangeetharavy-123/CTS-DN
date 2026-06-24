#E-commerce Platform Search Function

## Objective

Implement Linear Search and Binary Search to search products in an e-commerce platform.

## Classes Used

### Product.java

Contains:

* productId
* productName
* category

### SearchAlgorithms.java

Contains:

* Linear Search
* Binary Search
* Main Method

## Algorithms

### Linear Search

Checks each product one by one until the required product is found.

Time Complexity:

* Best Case: O(1)
* Average Case: O(n)
* Worst Case: O(n)

### Binary Search

Searches by repeatedly dividing the sorted array into two halves.

Time Complexity:

* Best Case: O(1)
* Average Case: O(log n)
* Worst Case: O(log n)

## Input

Product ID entered by the user.

## Output

Displays product details if found.

## Conclusion

Binary Search is more efficient for large datasets because it reduces the search space by half in each iteration, resulting in O(log n) time complexity.
