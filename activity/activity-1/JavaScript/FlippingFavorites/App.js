/**
 * Main function to process snack distribution.
 * When a child has a favorite snack number, we "flip" it by incrementing it by 1.
 * If the incremented value exceeds k (the maximum snack number), we reset it to 1.
 */
function processSnacks() {
    // For Node.js environment, we'll use readline for input
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    let lineCount = 0;
    let n = 0, k = 0;
    let snacks = [];

    // Process input lines
    rl.on('line', (line) => {
        if (lineCount === 0) {
            // First line: n (number of children) and k (maximum snack number)
            const [nVal, kVal] = line.trim().split(/\s+/).map(Number);
            
            // Validate constraints
            if (nVal < 1 || nVal > 100 || kVal < 1 || kVal > 100) {
                console.log("Input values out of constraints range.");
                rl.close();
                return;
            }
            
            n = nVal;
            k = kVal;
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