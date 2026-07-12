public class Operations {

    public static void reverseString() {

        String text = "Java";
        String result = " ";

        for (int i = text.length() - 1; i >= 0; i--) {
            result += text.charAt(i);
        }

        System.out.println("Original String : " + text);
        System.out.println("Reversed String : " + result);
    }

    public static void checkPrime() {

        int number = 5;
        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }
    }

    
    public static void findPrimeNumbers() {

        int n = 20;

        System.out.print("Prime Numbers : ");

        for (int i = 2; i <= n; i++) {

            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }

   
    public static void findLargest() {

        int[] numbers = {1, 2, 3, 4, 5, 6};

        int largest = numbers[0];

        for (int num : numbers) {
            if (num > largest) {
                largest = num;
            }
        }

        System.out.println("Largest Number : " + largest);
    }

    
    public static void findSmallest() {

        int[] numbers = {1, 2, 3, 4, 5, 6};

        int smallest = numbers[0];

        for (int num : numbers) {
            if (num < smallest) {
                smallest = num;
            }
        }

        System.out.println("Smallest Number : " + smallest);
    }

    
    public static void findSum() {

        int[] numbers = {1, 2, 3, 4, 5, 6};

        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        System.out.println("Sum of Array Elements : " + sum);
    }
}