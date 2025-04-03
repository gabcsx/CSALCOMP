# Problem B : Flipping Favorites

### Requirements:

#### Input Format
* The first line contains two integers n and k - the number of children and the maximum snack number.
* The second line contains space-separated integer a sub 1, a sub 2,...., a sub n - the initial favorite snack numbers of the children.

#### Constraints
* 1 ≤ n ≤ 100
* 1 ≤ k ≤ 100
* 1 ≤ a ≤ k

#### Output Format
* Output n space-separated integers, the new favorite snack numbers of the children after flipping

| Sample Input | Sample Output |
|--------------|---------------|
| 5 4          | 2 3 4 1 3     |
| 1 2 3 4 2    |               |
|--------------|---------------|
| 3 5          | 1 1 2         |
| 5 5 1        |               |

# 📁 Previous Version 

App.java 
```
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
```

<!-- End point line insert Thanks for visiting enjoy your day, feel free to modify this  -->
---
<p align="center">
<img src="https://readme-typing-svg.demolab.com/?lines=Thanks+For+Visiting+Enjoy+Your+Day+~!;" alt="mystreak"/>
</p>

<!-- Genshin Impact -->
<div align="center">
<img src="https://media.giphy.com/media/BqjYZq0yMVRYvyCfgL/giphy.gif?cid=ecf05e476fpqi63k6pmpvgbhklal1pw4ewurwhz1gezg1ag0&ep=v1_stickers_search&rid=giphy.gif&ct=s" width="300">
</div>

<!-- End point line insert Comeback again next time, feel free to modify this  -->
<p align="center">
<img src="https://readme-typing-svg.demolab.com/?lines=💎💎Come+Back+Again+next+time💎💎" alt="mystreak"/>
</p>

</p>
    
<br>
<!-- End point insert background effect line of sight color red -->
<img src="https://user-images.githubusercontent.com/74038190/212284100-561aa473-3905-4a80-b561-0d28506553ee.gif" width="1000">
