package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

/**
 * Main function to process snack distribution.
 * When a child has a favorite snack number, we "flip" it by incrementing it by 1.
 * If the incremented value exceeds k (the maximum snack number), we reset it to 1.
 */
func main() {
	scanner := bufio.NewScanner(os.Stdin)
	
	// Read first line: n (number of children) and k (maximum snack number)
	scanner.Scan()
	firstLine := strings.Fields(scanner.Text())
	
	if len(firstLine) != 2 {
		fmt.Println("Invalid input format for first line.")
		return
	}
	
	n, err1 := strconv.Atoi(firstLine[0])
	k, err2 := strconv.Atoi(firstLine[1])
	
	if err1 != nil || err2 != nil {
		fmt.Println("Error parsing n or k values.")
		return
	}
	
	// Validate constraints
	if n < 1 || n > 100 || k < 1 || k > 100 {
		fmt.Println("Input values out of constraints range.")
		return
	}
	
	// Read second line: initial favorite snack numbers
	scanner.Scan()
	secondLine := strings.Fields(scanner.Text())
	
	if len(secondLine) != n {
		fmt.Println("Invalid number of snack inputs.")
		return
	}
	
	snacks := make([]int, n)
	
	// Parse and validate snack numbers
	for i := 0; i < n; i++ {
		snack, err := strconv.Atoi(secondLine[i])
		if err != nil {
			fmt.Println("Error parsing snack value.")
			return
		}
		
		if snack < 1 || snack > k {
			fmt.Println("Snack number out of valid range.")
			return
		}
		
		snacks[i] = snack
	}
	
	// Process the "flip" operation
	for i := 0; i < n; i++ {
		if snacks[i] == k {
			snacks[i] = 1
		} else {
			snacks[i]++
		}
	}
	
	// Output the result
	for i, snack := range snacks {
		fmt.Print(snack)
		if i < len(snacks)-1 {
			fmt.Print(" ")
		}
	}
	fmt.Println()
}