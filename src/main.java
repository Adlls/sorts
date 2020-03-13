import javafx.scene.control.Cell;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class main {

    static integer count = new integer(0);

    public static void main(String args[]) {

        int[] arr = {12, 14, 5, 6, 8, 66, 342, 2, 3};
        //ImrovedBubbleSort(arr);
        String[] values = new String[100];
        int[] priorites = new int[100];


       //BucketSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


/*
    static public void BucketSort(int[] values, int max, int numBuckets) {

        Cell[] buckets = new Cell[numBuckets];

        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new Cell();
        }

        float itemPerBucket = (max + 1f) / numBuckets;

        for (int i = 0; i < values.length; i++) {

            int value = values[i];
            int num = (int)(value / itemPerBucket);

            Cell afterMe = buckets[num];

            while ((afterMe != null) && (afterMe.Next.Value < value))
                afterMe = afterMe.Next;
                Cell cell = new Cell(value);
                cell.Next = afterMe.Next;
                afterMe.Next = cell;
        }

        // Gather the values back into the array.
        int index = 0;
        for (int i = 0; i < numBuckets; i++)
        {
            Cell cell = buckets[i].Next;
            while (cell != null)
            {
                values[index] = cell.Value;
                index++;
                cell = cell.Next;
            }
        }

    }
*/



    static public void CoutingSort(int[] arr, int max_val) {

        int[] counts = new int[max_val + 1];


        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]] = counts[arr[i]] + 1;
        }

        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) continue;
            for (int j = 1; j <= counts[i]; j++) {
                arr[index] = i;
                index++;
            }
        }

    }

    static public void QuickSort(int[] arr, int start, int end) {

        if (start >= end) return;

        int divider = arr[start];
        int lo = start;
        int hi = end;

        while (true) {

            while (arr[hi] >= divider) {
                hi = hi - 1;
                if (hi <= lo) break;
            }

            if (hi <= lo) {
                arr[lo] = divider;
                break;
            }

            arr[lo] = arr[hi];

            lo = lo + 1;

            while (arr[lo] < divider) {
                lo = lo + 1;
                if (lo >= hi) break;
            }

            if (lo >= hi) {
                lo = hi;
                arr[hi] = divider;
                break;
            }

            arr[hi] = arr[lo];

        }

        QuickSort(arr, start, lo - 1);
        QuickSort(arr, lo + 1, end);

    }

    static public void QuickSortQueue(int[] arr, int start, int end) {

        if (start >= end) return;

        ArrayDeque<Integer> before = new ArrayDeque<>();
        ArrayDeque<Integer> after = new ArrayDeque<>();
        int divider = arr[start];

        for (int i = start + 1; i <= end; i++) {

            if (arr[i] < divider) {
                before.push(arr[i]);
            }
            else {
                after.push(arr[i]);
            }
        }

        int index = start;
        while (before.size() > 0) {
            arr[index] = before.pop();
            index++;
        }

        int midpoint = index;
        arr[index] = divider;

        index++;
        while (after.size() > 0) {
            arr[index] = after.pop();
            index++;
        }

        QuickSortStack(arr, start, midpoint - 1);
        QuickSortStack(arr, midpoint + 1, end);

    }


    static public void QuickSortStack(int[] arr, int start, int end) {

        if (start >= end) return;

        Stack<Integer> before = new Stack<>();
        Stack<Integer> after = new Stack<>();
        int divider = arr[start];

        for (int i = start + 1; i <= end; i++) {

            if (arr[i] < divider) {
                before.push(arr[i]);
            }
            else {
                after.push(arr[i]);
            }
        }

        int index = start;
        while (before.size() > 0) {
            arr[index] = before.pop();
            index++;
        }

        int midpoint = index;
        arr[index] = divider;

        index++;
        while (after.size() > 0) {
            arr[index] = after.pop();
            index++;
        }

        QuickSortStack(arr, start, midpoint - 1);
        QuickSortStack(arr, midpoint + 1, end);

    }

    static public int[] Heapsort(int[] arr) {


        PriorityQueue.MakeHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {

            int val = PriorityQueue.RemoveTopItem(arr, new integer(i + 1));
            arr[i] = val;

        }

        return arr;


    }

    static public void SortInsert(int[] arr) {

        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int dot = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = dot;
                j--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static public void SelectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static public void BubbleSort(int[] arr) {
        boolean not_sorted = true;

        while (not_sorted) {
            not_sorted = false;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    not_sorted = true;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static public void ImrovedBubbleSort(int[] arr) {
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        int lastSwap = 0;

        //maxindex always will be more than minIndex
        while (maxIndex >= minIndex) {

            minIndex = lastSwap;
            for (int i = minIndex; i < maxIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                    lastSwap = i;
                }
            }
            
            maxIndex = lastSwap;

            if (minIndex >= maxIndex) break;

            for (int i = maxIndex; i > minIndex; i--) {
                if (arr[i - 1] > arr[i]) {
                    int tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                    lastSwap = i;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

