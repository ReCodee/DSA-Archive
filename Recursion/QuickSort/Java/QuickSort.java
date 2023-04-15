package Recursion.QuickSort.Java;
import java.util.*;

public class QuickSort {

 
    static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int Partition(int[] arr, int low, int high) {
        //System.out.println("Function");
        int i = low;
        int j = high;
        int pivot = low;
        while ( i < j ) {
           // System.out.println("Loop");
            while(arr[i] <= arr[pivot] && i < high) {
                i++;
            }
            //System.out.println(arr[i]);
            while(arr[j] > arr[pivot] && j > low) {
                j--;
            }
            //System.out.println(arr[j]);
            if ( i < j ) {
                //System.out.println(arr[i] + " " + arr[j]);
                Swap(arr, i, j);
                //System.out.println(arr[i] + " " + arr[j]);
            }
        }
        Swap(arr, pivot, j);
        return j;
    }

    static void SortQuick(int[] arr, int low, int high) {
        if ( low < high ) {
            int p = Partition(arr, low, high);
            SortQuick(arr, low, p - 1);
            SortQuick(arr, p + 1, high);
        }
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for ( int i = 0 ; i < n ; i++ ) {
            arr[i] = sc.nextInt();
        }
        SortQuick(arr, 0, arr.length - 1);
        for ( int i = 0 ;  i < n ; i++ ) 
         System.out.print(arr[i] + " ");
        sc.close();
        System.out.println();
    }
    
}
