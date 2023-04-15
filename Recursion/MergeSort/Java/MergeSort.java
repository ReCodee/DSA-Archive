package Recursion.MergeSort.Java;
import java.util.*;

class MergeSort {



    static void Merge(int[] nums, int s, int mid, int e) {
        int[] copy = new int[nums.length];

        int i = s, j = mid + 1, counter = 0;
        while ( i <= mid && j <= e ) {

            if ( nums[i] < nums[j] ) {
                copy[counter] = nums[i];
                i++;
            } else {
                copy[counter] = nums[j];
                j++;  
            }
            counter++;
        }

        while ( i <= mid ) {
            copy[counter] = nums[i];
            i++;
            counter++;
        }

        while( j <= e ) {
            copy[counter] = nums[j];
            j++;
            counter++;
        }

        for ( int ele = s ; ele <= e ; ele++ ) {
            nums[ele] = copy[ele - s];
             System.out.print(copy[ele - s] + " ");
        }
        System.out.println();
          
    }

    static void MergeS(int[] nums, int s, int e) {
        if ( s >= e ) {
            return;
        }

        int mid = (s + e) / 2;
        MergeS(nums, s, mid);
        MergeS(nums, mid + 1, e);

        Merge(nums, s, mid, e);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for ( int i = 0 ; i < n ; i++ ) {
            nums[i] = sc.nextInt();
        }

        MergeS(nums, 0, nums.length - 1);
        
        for(int e : nums)
        System.out.print(e + " ");

        sc.close();
    }

}