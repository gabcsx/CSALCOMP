import java.util.Scanner;

/**
 * Main application class that processes snack distribution according to problem requirements.
 * When a child has a favorite snack number, we "flip" it by incrementing it by 1.
 * If the incremented value exceeds k (the maximum snack number), we reset it to 1.
 */
public class App {
    /**
     * Main entry point of the application.
     * Reads input, processes snack numbers according to requirements, and displays the result.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Read first line: n (number of children) and k (maximum snack number)
            String[] firstLine = scanner.nextLine().trim().split("\\s+");
            int n = Integer.parseInt(firstLine[0]);
            int k = Integer.parseInt(firstLine[1]);
            
            // Validate constraints
            if (n < 1 || n > 100 || k < 1 || k > 100) {
                System.out.println("Input values out of constraints range.");
                return;
            }
            
            // Read second line: initial favorite snack numbers
            String[] secondLine = scanner.nextLine().trim().split("\\s+");
            int[] snacks = new int[n];
            
            // Parse and validate snack numbers
            for (int i = 0; i < n; i++) {
                snacks[i] = Integer.parseInt(secondLine[i]);
                if (snacks[i] < 1 || snacks[i] > k) {
                    System.out.println("Snack number out of valid range.");
                    return;
                }
            }
            
            // Process the "flip" operation: increment each snack number or reset to 1 if exceeds k
            for (int i = 0; i < n; i++) {
                if (snacks[i] == k) {
                    snacks[i] = 1;
                } else {
                    snacks[i]++;
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
            System.out.println("Error processing input: " + e.getMessage());
        }
    }
}