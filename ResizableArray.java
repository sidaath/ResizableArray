public class ResizableArray{
    private int[]  initialArray = {-1, -1, -1, -1};
    private int[]  currentArray = initialArray;        


    public void printArray(){
        for(int i = 0; i < currentArray.length; i++){
            System.out.println("Index "+i+" = "+currentArray[i]);
        }
    }
    
    public int addNum(int num){
        return add(num);
    }

    public void addNUm(int num, int position){
        add(num, position);
    }

    public int countNums(){
        return count();
    }

    public int countCapacity(){
        return freeCapacity();
    }

    public int getSize(){
        return arraySize();
    }

    public int findNum(int num){
        return findNext(num, 0);
    }

    public int findNum(int num, int index){
        return findNext(num, index);
    }

    public int removeNum(int num){
        return removeAll(num);
    }

    public void insertAtBeginning(int num){
        add(num, 0);
    }


    public void deleteByIndex(int index){
        currentArray[index] = -1;
    }

    //return next free position
    private int findNextFreePosition(){
        int  index   = 0;
        int position = currentArray[index];

        while(position != -1){
            index++;
            position = currentArray[index];
        }

        return index;
    }

    //return number of availbale positions
    private int freeCapacity(){
        int  cap = 0;
        for (int i : currentArray) {
            if(i == -1){
                cap = cap + 1;
            }
        }
        
        return cap;
    }

    //add new number at next available position
    private int add(int number){
        int freeIndexCount  = freeCapacity();

        if(freeIndexCount <= currentArray.length/4){
            resize();
        }
        int nextIndex       = findNextFreePosition();
        currentArray[nextIndex] = number;
        
        return nextIndex; 
    }

    //add new number at specific index
    private void add(int number, int index){
        if(!(index < currentArray.length && index >= 0)){
            System.out.println("Index out of range");
        }

        if(index != 0){
            if(currentArray[index] != -1){
                System.out.println("conflict at position");
            }
        }
        

        int freeIndexCOunt = freeCapacity();
        
        if(freeIndexCOunt <= currentArray.length/4){
            resize();
        }
        
        for(int i = currentArray.length -2; i >= index; i--){
            currentArray[i+1] = currentArray[i]; 
        }

        currentArray[index] = number;
        System.out.println("Entered "+number+" at index "+index);
    }
    
    //create new array of twice the size and move elements to new array
    private void resize(){
        System.out.println("Beginning resizing...");
        int arraySize   = currentArray.length;
        System.out.println("current length = "+arraySize);
        int[] temp      = new int[arraySize * 2];
        for(int i =0; i < currentArray.length; i++){
            temp[i] = currentArray[i];
        }

        for(int i = currentArray.length; i < (currentArray.length) * 2; i++){
            temp[i] = -1;
        }

        currentArray = temp;
        System.out.println("done resizing, new len = "+currentArray.length);

    }


    //find first occurance from given point
    private int findNext(int number, int startIndex){
        for(int i = startIndex; i < currentArray.length; i++){
            if(currentArray[i] == number){
                return i;
            }
        }

        return -1;
    }

    //remove all occurances of number
    private int removeAll(int number){
        int count = 0;
        for (int i = 0; i < currentArray.length; i++){
            if(currentArray[i] == number){
                currentArray[i] = -1;
                count++;
            }
        }

        return count;
    }

    //count entered ints
    private int count(){
        int count = 0;

        for(int i =0; i < currentArray.length; i++){
            if(currentArray[i] != -1){
                count++;
            }
        }

        return count;
    }

    //return array size
    private int arraySize(){
        return currentArray.length;
    }
}
