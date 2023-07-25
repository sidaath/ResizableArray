public class ResizableArray{
    private int[]  initialArray = {-1, -1, -1, -1};
    private int[]  currentArray = initialArray;        


    public void printArray(){
        for(int i = 0; i < currentArray.length; i++){
            System.out.println("Index "+i+" = "+currentArray[i]);
        }
    }
    
    public int addNum(int num){
        System.out.println("calling private methpd");
        return add(num);
    }

    public void addNUm(int num, int position){
        add(num, position);
    }


    public void deleteByIndex(int index){
        currentArray[index] = -1;
    }

    //return next free position
    public int findNextFreePosition(){
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
        System.out.println("begin privat method add");
        int freeIndexCount  = freeCapacity();
        System.out.println("end of free capacity");

        if(freeIndexCount <= currentArray.length/4){
            resize();
        }
        System.out.println("begin find next pos");
        int nextIndex       = findNextFreePosition();
        System.out.println("end of finding next posituing");
        currentArray[nextIndex] = number;
        
        System.out.println("end priv method, returning "+nextIndex);
        return nextIndex; 
    }

    //add new number at specific index
    private void add(int number, int index){
        if(!(index < currentArray.length)){
            System.out.println("Index out of range");
        }

        if(currentArray[index] != -1){
            System.out.println("conflict at position");
        }

        int freeIndexCOunt = freeCapacity();
        
        if(freeIndexCOunt <= currentArray.length/4){
            resize();
        }
        
        for(int i = currentArray.length -2; i > index; i--){
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
}
