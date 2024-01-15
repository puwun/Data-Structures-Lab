package lab4;
import java.util.Scanner;

/**
 * A test application for the GenericStack class, allowing the user to interact
 * with a stack.
 * 
 */
public class GenericStackApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Define the limit for the stack: ");
        int capacity = sc.nextInt();
        GenericStack<Integer> stack = new GenericStack<>(capacity);
        int select;
        do {
            System.out.print("""
                    Menu:
                    1. Push Element
                    2. Pop Element
                    3. Top Element
                    4. Check if Empty
                    5. Check if Full
                    0. Exit Program
                    Enter Sr. No. of Operation:\s""");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.print("Please input the element you wish to push: ");
                    int temp = sc.nextInt();
                    stack.push(temp);
                    break;

                case 2:
                    System.out.println("The element popped is: " +
                            stack.pop());
                    break;

                case 3:
                    System.out.println("The element at the top is: " +
                            stack.top());
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        System.out.println("The Stack is Empty");
                    } else {
                        System.out.println("The Stack is not Empty");
                    }
                    break;

                case 5:
                    if (stack.isFull()) {
                        System.out.println("The Stack is Full");
                    } else {
                        System.out.println("The Stack is not Full");
                    }
                    break;

                case 0:
                    System.out.println("Exited program successfully");
                    break;

                default:
                    throw new IllegalArgumentException("Invalid Option");
            }
        } while (select != 0);
        sc.close();
    }
}
