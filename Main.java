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
            System.out.println("5. count nums");
            System.out.println("6. capacity");
            System.out.println("7. array size");
            System.out.println("8. find number");
            System.out.println("9. remove from array");
            System.out.println("10. Add to beginning");
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

                case 5:
                    System.out.println("Count = "+resizableArray.countNums());
                    break;

                case 6:
                    System.out.println("Capacity = "+resizableArray.countCapacity());
                    break;

                case 7:
                    System.out.println("Array size = "+resizableArray.getSize());
                    break;

                case 8:
                    System.out.println("Enter number to find:");
                    num = choiceScanner.nextInt();
                    index = resizableArray.findNum(num);
                    if(index != -1){
                        System.out.println("first Index = "+index);
                        int find = 0;
                       do {
                            System.out.println("Find again?\n");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            find = choiceScanner.nextInt();
                            if(find == 1){

                                index = resizableArray.findNum(num, index + 1);
                                if(index != -1){
                                    System.out.println("Next index = "+index);
                                }else{
                                    System.out.println("No other occurances");
                                    find = 2;
                                }
                            }
                       } while (find == 1);
                    }else{
                        System.out.println("Not found");
                    }
                    break;

                case 9:
                    System.out.println("Enter number to delete from array:");
                    num = choiceScanner.nextInt();
                    System.out.println("Removed "+resizableArray.removeNum(num)+" items");
                    break;

                case 10:
                    System.out.println("Enter number: ");
                    num = choiceScanner.nextInt();
                    resizableArray.insertAtBeginning(num);
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