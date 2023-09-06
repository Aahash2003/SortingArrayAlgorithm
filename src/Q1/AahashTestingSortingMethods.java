package Q1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class AahashTestingSortingMethods<T> {
    public static void main(String[] args) {
        header(2,1,"Aahash Srikumar", 251225561, "write all the sorting methods we discussed in the class\n" +
                "in their generic form and check their execution time for an Integer type dataset.");
        Scanner input = new Scanner(System.in);
        Integer[] arr = new Integer[30000];//ineteger array
        Integer[] backup = new Integer[30000];
        int min = 0;
        int max= arr.length-1;// max length
        for (int i = 0; i < arr.length; i++) {// math random populating array
            arr[i] = ((int) (Math.random() * 80)) + 13;
        }
        for (int i = 0; i < arr.length; i++) {// copying array
            backup[i] = arr[i];
        }

        List<Integer> a = Arrays.asList(arr);//using list for natural order
        List<Integer> b = Arrays.asList(backup);
        long time1 = System.nanoTime();// timing the method
        Collections.sort(a);
        long time2 = System.nanoTime();
        long time = time2 - time1;// finding the difference
       System.out.println("Testing execution time of different sorting methods for sorting "+ arr.length +" random numbers:");
        NumberFormat num = new DecimalFormat();
        num = new DecimalFormat("0.##");
/*
        System.out.println("The unsorted list: " + b.toString());//printing the method
        System.out.printf("Collections' Sorting Time: %s milliseconds\nThe sorted list using Collections' sort method: %s\n\n", num.format(time/1000000.00), a.toString());
        reverse(arr, backup);//reversing back to old array
        selectionSort(arr);//calling selection
        System.out.printf("The unsorted list: %s \nMy Selection-Sort Time: %s milliseconds\nThe sorted list using selection-sort: %s\n\n", b.toString(), num.format(selectionSort(arr)/1000000.00), a.toString());
        reverse(arr, backup);
        bubbleSort(arr);
        System.out.printf("The unsorted list: %s \nMy Bubble-Sort Time: %s milliseconds\nThe sorted list using Bubble-sort: %s\n\n", b.toString(), num.format(bubbleSort(arr)/1000000.00), a.toString());
        reverse(arr, backup);
        insertionSort(arr);
        System.out.printf("The unsorted list: %s \nMy Insertion-Sort Time: %s milliseconds\nThe sorted list using Insertion-sort: %s\n\n", b.toString(), num.format(insertionSort(arr)/1000000.00), a.toString());
        reverse(arr, backup);
        mergeSort(arr);
        System.out.printf("The unsorted list: %s \nMy Merge-Sort Time: %s milliseconds\nThe sorted list using Merge-sort: %s\n\n", b.toString(), num.format(mergeSort(arr)/1000000.00), a.toString());
        reverse(arr, backup);
       quickSort(arr,min,max);//inputting max and min of the array size
        System.out.printf("The unsorted list: %s \nMy Quick-Sort Time: %s milliseconds\nThe sorted list using Quick-sort: %s\n\n", b.toString(), num.format(quickSort(arr,min,max)/1000000.00), a.toString());
        reverse(arr, backup);
        bucketSort(arr,min,max,10);
        System.out.printf("The unsorted list: %s \nMy Bucket-Sort Time: %s milliseconds\nThe sorted list using Bucket-sort: %s\n\n", b.toString(), num.format(bucketSort(arr,min,max,10)/1000000.00), a.toString());
        reverse(arr, backup);

*/
        System.out.printf("Collections' Sorting Time: %s milliseconds\n",num.format(time/1000000.00));
        reverse(arr, backup);
        selectionSort(arr);
        System.out.printf("My Selection-Sort Time: %s milliseconds\n",num.format(selectionSort(arr)/1000000.00));
        reverse(arr, backup);
        bubbleSort(arr);
        System.out.printf("My Bubble-Sort Time: %s milliseconds\n",num.format(bubbleSort(arr)/1000000.00));
        reverse(arr, backup);
        insertionSort(arr);
        System.out.printf("My Insertion-Sort Time: %s milliseconds\n",num.format(insertionSort(arr)/1000000.00));
        reverse(arr, backup);
        mergeSort(arr);
        System.out.printf("My Merge-Sort Time: %s milliseconds\n",num.format(mergeSort(arr)/1000000.00));
        reverse(arr, backup);
        quickSort(arr,min, max);
        System.out.printf("My Quick-Sort Time: %s milliseconds\n",num.format(quickSort(arr,min,max)/1000000.00));
        reverse(arr, backup);
        bucketSort(arr,min, max, 10);
        System.out.printf("My Bucket-Sort Time: %s milliseconds\n",num.format(bucketSort(arr,min,max,10)/1000000.00));

        footer("Aahash",2,1);


    }


    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        long start1 = System.nanoTime();//starting the timer
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {// comparing the elements
                if (a[i].compareTo(a[j]) > 0) {
                    min = j;
                }
            }
            if (min != i) {//swapping the elements
                T swap = a[min];
                a[min] = a[i];
                a[i] = swap;
            }
        }
        long finish1 = System.nanoTime();
        return (finish1-start1);//ending the array timer
    }

    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        long start1 = System.nanoTime();
        for (int i = 1; i < a.length; i++)
            for (int j = 0; j < a.length - i; j++)
                if (a[j].compareTo(a[j + 1]) > 0) {//comparing the elements
                    T temp = a[j];//swapping the elements
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                }
        long finish1 = System.nanoTime();
        return (finish1-start1);
    }

    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        long start1 = System.nanoTime();
        int n = a.length;
        int i=0;
        int j =0;
        for ( i = 1; i < n; i++) {
            T key = a[i];
            for (j =i-1; j>=0 && (a[j].compareTo(key) > 0); j--) {
              a[j+1]= a[j];
            }
            a[j+1]= key;
        }
        long finish1 = System.nanoTime();
        return (finish1-start1);
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] s) {
        long start1 = System.nanoTime();
        int n = s.length;
        if (n < 2) return 1; // array is trivially sorted
        // divide
        int mid = n / 2;
        T[] S1 = Arrays.copyOfRange(s, 0, mid); // copy of first half
        T[] S2 = Arrays.copyOfRange(s, mid, n); // copy of second half
        // conquer (with recursion)
        mergeSort(S1); // sort copy of first half
        mergeSort(S2); // sort copy of second half
        // merge sorted halves back into original
        int i = 0, j = 0;
        while (i + j < s.length) {
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0))
                s[i + j] = S1[i++];
            else
                s[i + j] = S2[j++];
        }
        long finish1 = System.nanoTime();
        return (finish1-start1);
    }

    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b) {
        long start1 = System.nanoTime();
        if (a >= b) {
            return 0;
        }
        int left = a;
        int right = b - 1;
        T p = s[b];
        while(left<= right) {//has to be less than and equal to
            while ((left <= right) && (s[left].compareTo(p) < 0))//compares the values
                left = left + 1;
            while ((left <= right) && (s[right].compareTo(p) > 0))
                right = right - 1;

            if (left <= right) {//reassigning the elements
                T temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left = left + 1;
                right = right - 1;

            }
        }
            T temp = s[left];
            s[left] = s[b];
            s[b] = temp;

            quickSort(s, a, left - 1);//recursive call
                quickSort(s, left + 1, b);
        long finish1 = System.nanoTime();
        return (finish1-start1);
    }

    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        //since the radix is 10, creating 10 buckets using Vector. Assumption:
        long start1 = System.nanoTime();
        Vector<Integer>[] bucket = new Vector[10];//vector object
        //instantiate each bucket
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //Placing a[index] at end of bucket[digit]
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);//calling the method
                bucket[digit].add(a[index]);
            }
            //placing all the buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        long finish1 = System.nanoTime();
        return (finish1-start1);
    }

    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }

    public static void reverse(Integer [] arr, Integer []backup ) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = backup[i];
        }
    }
        public static void header(int number, int question, String name, int SD, String explanation) {
            System.out.println("===================================================================");
            System.out.printf(" Lab Exercise %d,Q%d \n Prepared By: %s \n Student Number: %d \n Goal of this Exercise: %s\n", number,question, name, SD, explanation);
            System.out.println("===================================================================");
        }

        public static void footer(String name, int lab, int q) {
            System.out.println("===================================================================");
            System.out.printf("Completion of Lab Assignment %d, %d is successful!\nSigning Off - %s\n", lab,q, name);
            System.out.println("===================================================================");
        }

}
