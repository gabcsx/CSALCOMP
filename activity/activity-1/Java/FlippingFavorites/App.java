import java.util.*;

/**
 * Main application class implementing a snack distribution algorithm.
 * When a child has a favorite snack number, we "flip" it by incrementing it by 1.
 * If the incremented value exceeds k (the maximum snack number), we reset it to 1.
 * Handles user input processing and manages snack quantity increments.
 */
public class App {
    /**
     * Main entry point of the application.
     * Processes user input and coordinates snack distribution logic.
     * Reads input, processes snack numbers according to requirements, and displays the result.
     * @param args Command line arguments (not used)
     * @throws Exception If input processing fails
     */
    public static void main(String[] args) throws Exception {
        boolean looper = true; // Controls main program loop
        
        while(looper) {
            try {
                int k = 0; // Maximum snack number limit
                int n = 0; // Number of children
                String stringInput = ""; // Temporary storage for input
                
                // Initialize arrays for tracking snacks
                int[] a = new int[40]; // Stores initial snack quantities
                int[] snack = new int[40]; // Tracks updated snack counts
                
                Scanner userInput = new Scanner(System.in);
                
                // Get initial values (n and k)
                while(true) {
                    stringInput = userInput.nextLine();
                    String[] parts = stringInput.split("\\s+");
                    
                    // Parse input values
                    n = Integer.parseInt(parts[0]); // Number of children
                    k = Integer.parseInt(parts[1]); // Maximum snack limit
                    
                    boolean invalidInput = false; // Track invalid input

                    // Validate input ranges
                    if (!(n <= 100 && n >= 1)) {
                        System.out.println("Invalid Input for n, try again");
                        invalidInput = true;
                    }
                    
                    if (!(k <= 100 && k >= 1)) {
                        System.out.println("Invalid Input for k, try again");
                        invalidInput = true;
                    }
                    
                    // Exit loop if both inputs are valid
                    if (!invalidInput) {
                        break;
                    }
                }
                
                // Process second line of input (individual snack quantities)
                stringInput = userInput.nextLine();
                String[] parts2 = stringInput.split("\\s+");

                boolean hasInvalidInput = false; // Track invalid input
                
                // Load initial snack values
                for (int i = 0; i < n; i++) {
                    try {
                        a[i] = Integer.parseInt(parts2[i]);
                        
                        // Throw if out of range (1 to k)
                        if (a[i] < 1 || a[i] > k) {
                            throw new IllegalArgumentException("Invalid Input for a[" + (i + 1) + "], must be between 1 and " + k);
                        }
                    } catch (IllegalArgumentException e) {
                        if (!hasInvalidInput) {
                            System.out.println(); // Add space when first error occurs
                        }
                        System.out.println(e.getMessage()); // Prints range error
                        hasInvalidInput = true;
                    }
                }

                // Exit program if any invalid input was found
                if (hasInvalidInput) {
                    return;
                }

                // Filter snacks within valid range (1 to k)
                for(int i = 0; i < n; i++) {
                    if (a[i] >= 1 && a[i] <= k) {
                        snack[i] = a[i];
                    }
                }
                
                // Process the "flip" operation: increment each snack number or reset to 1 if exceeds k
                for(int i = 0; i < n; i++) {
                    if (snack[i] >= k) {
                        snack[i] = 1; // Reset to minimum if exceeds maximum
                    } else {
                        snack[i] += 1; // Otherwise increment normally
                    }
                }
                
                // Output the result
                System.out.println(); // Add space before output only if there was an error
                for(int i = 0; i < n; i++) {
                    System.out.print(snack[i] + " ");
                }
                System.out.println();
                
                looper = false; // Exit main loop
            } catch(Exception e) {
                // Handle invalid input or processing errors
                System.out.println("\nError: " + e);
                System.out.println("Make sure your inputs are correct. Repeating program...\n");
            }
        }
    }
}
