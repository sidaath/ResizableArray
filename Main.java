import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResizableArray resizableArray = new ResizableArray();
        int[] initArray = new int[8];
        int[] currentArray = initArray;
        int usedInt = 0;
        int freeInt = 8;
        boolean cont = true;
        

        while (cont) {
            System.out.println("Pick Option");
            System.out.println("1. view array");
            System.out.println("2. add num");
            System.out.println("3. Delete num at index");
            System.out.println("4. Insert num at index");
            System.out.println("Quit - Q");

            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    resizableArray.printArray(currentArray);
                    break;
                
                case "2":
                    System.out.println("enter number:");
                    int input = scanner.nextInt();
                    int[] addRes = new int[2];
                    addRes = resizableArray.addNum(input, currentArray, freeInt, usedInt);
                    usedInt = addRes[0];
                    freeInt = addRes[1];

                    if(freeInt <= currentArray.length/4){
                        System.out.println("Resizing array");
                        System.out.println("Old array len = "+currentArray.length);
                        System.err.println("Available slots old = "+freeInt);
                        currentArray = resizableArray.resizeArray(currentArray);
                        freeInt = currentArray.length - usedInt;
                        System.out.println("New array len = "+currentArray.length);
                        System.err.println("Available slots new = "+freeInt);
                    }
                    break;

                case "3":
                    System.out.println("Enter index of number to delete");
                    int res = resizableArray.deleteByIndex(scanner.nextInt(), currentArray);
                    System.out.println("Deleted num "+res);
                    freeInt = freeInt + 1;
                    usedInt = usedInt - 1;
                    break;
                    
                case "4":
                    System.out.println("Enter number to insert:");
                    int num = scanner.nextInt();
                    System.out.println("Enter index to insert at: ");
                    int index = scanner.nextInt();
                    int[] addRes2 = new int[2];
                    addRes2 = resizableArray.enterAtIndex(num, index, freeInt, usedInt, currentArray);
                    usedInt = addRes2[0];
                    freeInt = addRes2[1];
                    if(freeInt <= currentArray.length/4){
                        System.out.println("Resizing array");
                        System.out.println("Old array len = "+currentArray.length);
                        System.out.println("Available slots old = "+freeInt);
                        currentArray = resizableArray.resizeArray(currentArray);
                        freeInt = currentArray.length - usedInt;
                        System.out.println("New array len = "+currentArray.length);
                        System.out.println("Available slots new = "+freeInt);
                    }
                    break;
                
                case "Q":
                    cont = false;
                    break;
                case "q":
                    cont = false;
                    break;
            }
        }

        scanner.close();
    }
}