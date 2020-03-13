
public class PriorityQueue {

   public static int[] MakeHeap(int[] arr) {
       int index = 0;
       for (int i = 0; i < arr.length; i++) {
           index = i;

           while (index !=0) {
               int parent = (index - 1) / 2;

               if (arr[index] < arr[parent]) break;

               int tmp = arr[index];
               arr[index] = arr[parent];
               arr[parent] = tmp;
               index = parent;
           }
       }
       return arr;
   }

   public static int RemoveTopItem(int[] arr, integer count) {
       int result = arr[0];
       arr[0] = arr[count.getValue() - 1];
       count.addtoValue(-1);

       int index = 0;
       for (;;) {
           int ch1 = 2*index + 1;
           int ch2 = 2*index + 2;

           if (ch1 >= count.getValue()) ch1 = index;
           if (ch2 >= count.getValue()) ch2 = index;

           if (arr[index] >= arr[ch1] && arr[index] >= arr[ch2]) break;

           int maxSwaped = arr[ch1] > arr[ch2] ? ch1 : ch2;

           int tmp = arr[index];
           arr[index] = arr[maxSwaped];
           arr[maxSwaped] = tmp;

           index = maxSwaped;
       }


       return result;
   }

   public static void push(String[] values, int[] priorites, integer count, String value, int priority) {
       values[count.getValue()] = value;
       priorites[count.getValue()] = priority;
       count.addtoValue(1);
       int index = count.getValue() - 1;

       while(index != 0) {
           int parent = (index - 1) / 2;
           if (priorites[parent] >= priorites[index]) break;

           String tempValue = values[index];
           values[index] = values[parent];
           values[parent] = tempValue;

           int tempPriority = priorites[index];
           priorites[index] = priorites[parent];
           priorites[parent] = tempPriority;

           index = parent;

       }
   }

   public static String pop(String[] values, int[] priorites, integer count) {

       String result = values[0];
       values[0] = values[count.getValue() - 1];
       priorites[0] = priorites[count.getValue() - 1];
       count.addtoValue(-1);
       int index = 0;

       while (true) {
           int ch1 = index*2 + 1;
           int ch2 = index*2 + 2;

           if (ch1 >= count.getValue()) ch1 = index;
           if (ch2 >= count.getValue()) ch2 = index;

           if (priorites[index] >= priorites[ch1] && priorites[index] >= priorites[ch2]) break;

           int maxSwaped = priorites[ch1] > priorites[ch2] ? ch1 : ch2;

           int tempPriorites = priorites[index];
           priorites[index] = priorites[maxSwaped];
           priorites[maxSwaped] = tempPriorites;

           String tempValues = values[index];
           values[index] = values[maxSwaped];
           values[maxSwaped] = tempValues;

           index = maxSwaped;
       }

       return result;

   }

}
