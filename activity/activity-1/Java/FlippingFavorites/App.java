import java.util.*;

/**
 * Main application class implementing a snack distribution algorithm.
 * When a child has a favorite snack number, we "flip" it by incrementing it by 1.
 * If the incremented value exceeds k (the maximum snack number), we reset it to 1.
 * Exits silently on any invalid input without error messages.
 */
public class App {
    /**
     * Main entry point of the application.
     * Processes user input and coordinates snack distribution logic.
     * Exits silently on any invalid input.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        try {
            // Get initial values (n and k)
            String firstLine = userInput.nextLine();
            String[] parts = firstLine.split("\\s+");
            
            // Exit silently if format is invalid
            if (parts.length != 2) {
                return;
            }
            
            // Parse input values and exit silently on any parsing error
            int n, k;
            try {
                n = Integer.parseInt(parts[0]); // Number of children
                k = Integer.parseInt(parts[1]); // Maximum snack limit
            } catch (NumberFormatException e) {
                return;
            }
            
            // Validate input ranges silently
            if (n < 1 || n > 100 || k < 1 || k > 100) {
                return;
            }
            
            // Process second line of input (individual snack quantities)
            String secondLine = userInput.nextLine();
            String[] snackValues = secondLine.split("\\s+");
            
            // Exit silently if input count doesn't match expected
            if (snackValues.length != n) {
                return;
            }
            
            int[] snacks = new int[n];
            
            // Load and validate snack values silently
            for (int i = 0; i < n; i++) {
                try {
                    snacks[i] = Integer.parseInt(snackValues[i]);
                    
                    // Exit silently if value is out of range
                    if (snacks[i] < 1 || snacks[i] > k) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    return;
                }
            }
            
            // Process the "flip" operation: increment each snack number or reset to 1 if equals k
            for (int i = 0; i < n; i++) {
                if (snacks[i] == k) {
                    snacks[i] = 1; // Reset to 1 if exactly equals maximum
                } else {
                    snacks[i]++; // Otherwise increment normally
                }
            }
            
            // Output the result
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                result.append(snacks[i]);
                if (i < n - 1) {
                    result.append(" ");
                }
            }
            System.out.println(result.toString());
            
        } catch (Exception e) {
            // Silently exit on any exception
            return;
        } finally {
            userInput.close();
        }
    }
}
