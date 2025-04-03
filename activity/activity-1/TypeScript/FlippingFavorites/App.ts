import * as readline from 'readline';

/**
 * Main function to process snack distribution.
 * When a child has a favorite snack number, we "flip" it by incrementing it by 1.
 * If the incremented value exceeds k (the maximum snack number), we reset it to 1.
 */
function processSnacks(): void {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    let lineCount: number = 0;
    let n: number = 0;
    let k: number = 0;
    let snacks: number[] = [];

    // Process input lines
    rl.on('line', (line: string) => {
        if (lineCount === 0) {
            // First line: n (number of children) and k (maximum snack number)
            const firstLine: number[] = line.trim().split(/\s+/).map(Number);
            n = firstLine[0];
            k = firstLine[1];
            
            // Validate constraints
            if (n < 1 || n > 100 || k < 1 || k > 100) {
                console.log("Input values out of constraints range.");
                rl.close();
                return;
            }
            
            lineCount++;
        } 
        else if (lineCount === 1) {
            // Second line: initial favorite snack numbers
            snacks = line.trim().split(/\s+/).map(Number);
            
            // Validate snack numbers and number of inputs
            if (snacks.length !== n) {
                console.log("Invalid number of snack inputs.");
                rl.close();
                return;
            }
            
            for (let i = 0; i < n; i++) {
                if (snacks[i] < 1 || snacks[i] > k) {
                    console.log("Snack number out of valid range.");
                    rl.close();
                    return;
                }
            }
            
            // Process the "flip" operation
            for (let i = 0; i < n; i++) {
                if (snacks[i] === k) {
                    snacks[i] = 1;
                } else {
                    snacks[i]++;
                }
            }
            
            // Output the result
            console.log(snacks.join(' '));
            rl.close();
        }
    });
}

// Execute the main function
processSnacks();