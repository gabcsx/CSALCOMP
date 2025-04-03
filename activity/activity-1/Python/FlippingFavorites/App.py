def process_snacks():
    """
    Main function to process snack distribution.
    When a child has a favorite snack number, we "flip" it by incrementing it by 1.
    If the incremented value exceeds k (the maximum snack number), we reset it to 1.
    """
    try:
        # Read first line: n (number of children) and k (maximum snack number)
        first_line = input().strip().split()
        n = int(first_line[0])
        k = int(first_line[1])
        
        # Validate constraints
        if not (1 <= n <= 100 and 1 <= k <= 100):
            print("Input values out of constraints range.")
            return
        
        # Read second line: initial favorite snack numbers
        snacks = list(map(int, input().strip().split()))
        
        # Validate number of inputs and snack values
        if len(snacks) != n:
            print("Invalid number of snack inputs.")
            return
        
        for snack in snacks:
            if not (1 <= snack <= k):
                print("Snack number out of valid range.")
                return
        
        # Process the "flip" operation
        for i in range(n):
            if snacks[i] == k:
                snacks[i] = 1
            else:
                snacks[i] += 1
        
        # Output the result
        print(" ".join(map(str, snacks)))
        
    except Exception as e:
        print(f"Error processing input: {e}")

# Execute the main function
if __name__ == "__main__":
    process_snacks()