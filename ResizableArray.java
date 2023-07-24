public class ResizableArray{

    public int[] resizeArray(int[] currentArray){
        int newSize = currentArray.length * 2;
        int[] myNewArray = new int[newSize];

        for(int i =0; i < currentArray.length; i++){
            myNewArray[i] = currentArray[i];
        }

        return myNewArray;
    }

    public void printArray(int[] mainArray){
        for(int i = 0; i < mainArray.length; i++){
            System.out.println("Index "+i+" = "+mainArray[i]);
        }
    }
    
    public int[] addNum(int num, int[] array, int freePos, int usedPos){
        array[usedPos] = num;
        usedPos++;
        freePos--;
        
        int[] ret = new int[2];
        ret[0] = usedPos;
        ret[1] = freePos;
        return ret;
    }


    public int deleteByIndex(int index, int[] array){
        int temp = array[index];
        array[index] = -1;

        for(int i = index; i<array.length - 1; i++){
            System.out.println("Moving array "+i+" + 1 to "+i);
            array[i] = array[i+1];
        }

        return temp;
    }

    public int[] enterAtIndex (int num, int index, int freePos,int usedPos, int[] array){
        for(int i = usedPos; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = num;
        usedPos++;
        freePos--;
        int[] ret = new int[2];
        ret[0] = usedPos;
        ret[1] = freePos;
        return ret;

    }
}
