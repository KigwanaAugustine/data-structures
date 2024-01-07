package Arrays;

public class Array {
    private int[] items;
    private int count;

    public Array(int length){
        items = new int[length];
    }

    public void print(){
       for(int i= 0; i < count; i++){
        System.out.println(items[i]);
       }
    }

    public void insert(int item){
        //if items[] is full, first enlarge it
        if(count == items.length){
            var new_items = new int[count * 2];
            
            for (int i = 0; i < count; i++)
                new_items[i] = items[i];
            items = new_items;
        }
        //then insert the the item at the last position & increment count
        items[count++] = item;
    }

    public void removeAt(int index){
      //first validate index
      if(index < 0 || index > count)
        throw new IllegalArgumentException();

      //remove item by hole filling
      for(int i = index; i <= count; i++)
        items[i] = items[i+1];
      
      count--; //update the count
    }

    public int indexOf(int item){
        for(int i = 0; i < count; i++){
            if(items[i] == item)
            return i; 
        }
        return -1;
    }

    public int max(){
        int max = items[0];
        for (int i = 0; i < count; i++) {
            if(items[i] > max) 
                max = items[i];
        }
        return max;
    }

    public int getItem(int index){

        //validate index
        if(index < 0 || index > count)
            throw new IllegalArgumentException();

        return items[index];
    }

    // Method to find the intersection of two arrays
    public Array intersect(Array other) {
        var intersection = new Array(count); // Assuming count is the size of items array

        for (int i = 0; i < count; i++) {
            if (other.indexOf(items[i]) >= 0) {
                // Check if the item is not already in the intersection to avoid duplicates
                if (intersection.indexOf(items[i]) == -1) {
                    intersection.insert(items[i]);
                }
            }
        }

        return intersection;
    }

    // Method to reverse the array
    public void reverse() {
        int start = 0;
        int end = count - 1;
        while (start < end) {
            int temp = items[start];
            items[start] = items[end];
            items[end] = temp;
            start++;
            end--;
        }
    }

    //Inserting an item at a given index
    public void insertAt(int item , int index){
        //validate index
        if(index < 0 || index > count)
            throw new IllegalArgumentException();

        
    }
    
    public static void main(String[] args) {
        var numbers = new Array(5);
        numbers.insert(5);
        numbers.insert(500);
        numbers.insert(50);

        System.out.println(numbers.max());
        // numbers.print();
    }
}
