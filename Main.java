import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner choiceScanner = new Scanner(System.in);
        ResizableArray resizableArray = new ResizableArray();
        boolean cont = true;
        

        while (cont) {
            System.out.println("Pick Option");
            System.out.println("1. view array");
            System.out.println("2. add num");
            System.out.println("3. Delete num at index");
            System.out.println("4. Insert num at index");
            System.out.println("99. - Q");

            int choice = choiceScanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("printing array");
                    resizableArray.printArray();
                    break;
                
                case 2:
                    System.out.println("Enter number to add:");
                    int num = choiceScanner.nextInt();
                    System.out.println("after scan");
                    resizableArray.addNum(num);
                    System.out.println("after call");
                    break;
                
                case 3:
                    System.out.println("enter index:");
                    num = choiceScanner.nextInt();
                    resizableArray.deleteByIndex(num);
                    break;

                case 4:
                    System.out.println("Enter number");
                    num = choiceScanner.nextInt();
                    System.out.println("Enter index");
                    int index = choiceScanner.nextInt();
                    resizableArray.addNUm(num, index);
                    break;


                case 99:
                    cont = false;
            
                default:
                    System.out.println("invalid choice, select again");
                    break;

            }

            System.out.println("\n\n");
        }

        choiceScanner.close();
    }
}