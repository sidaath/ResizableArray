import java.util.Scanner;

public class ResizableArray{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("Quit - Q");

            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    printArray(currentArray);
                    break;
                
                case "2":
                    System.out.println("enter number:");
                    int input = scanner.nextInt();
                    int[] addRes = new int[2];
                    addRes = addNum(input, currentArray, freeInt, usedInt);
                    usedInt = addRes[0];
                    freeInt = addRes[1];

                    if(freeInt <= currentArray.length/4){
                        System.out.println("Resizing array");
                        System.out.println("Old array len = "+currentArray.length);
                        System.err.println("Available slots old = "+freeInt);
                        currentArray = resizeArray(currentArray);
                        freeInt = currentArray.length - usedInt;
                        System.out.println("New array len = "+currentArray.length);
                        System.err.println("Available slots new = "+freeInt);
                    }
                    break;

                case "3":
                    System.out.println("Enter index of number to delete");
                    int res = deleteByIndex(scanner.nextInt(), currentArray);
                    System.out.println("Deleted num "+res);
                    freeInt = freeInt + 1;
                    usedInt = usedInt - 1;
                    break;
                
                case "Q":
                    cont = false;
                    break;
                case "q":
                    cont = false;
                    break;
            
                default:
                    break;
            }
        }

        
    }

    private static int[] resizeArray(int[] currentArray){
        int newSize = currentArray.length * 2;
        int[] myNewArray = new int[newSize];

        for(int i =0; i < currentArray.length; i++){
            myNewArray[i] = currentArray[i];
        }

        return myNewArray;
    }

    private static void printArray(int[] mainArray){
        for(int i = 0; i < mainArray.length; i++){
            System.out.println("Index "+i+" = "+mainArray[i]);
        }
    }
    
    private static int[] addNum(int num, int[] array, int freePos, int usedPos){
        array[usedPos] = num;
        usedPos++;
        freePos--;
        
        int[] ret = new int[2];
        ret[0] = usedPos;
        ret[1] = freePos;
        return ret;
    }


    private static int deleteByIndex(int index, int[] array){
        int temp = array[index];
        array[index] = -1;

        for(int i = index; i<array.length - 1; i++){
            System.out.println("Moving array "+i+" + 1 to "+i);
            array[i] = array[i+1];
        }

        return temp;
    }
}
