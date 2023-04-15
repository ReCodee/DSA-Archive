package Recursion.Permutations.Java;
import java.util.*;

public class Permutations {
    
   public static void swap(int[] nums, int i, int j ) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }

  public static void OptimizedFindPermutations(int[] nums, List < List < Integer > > res, int index) {
      if ( index == nums.length ) {
        List < Integer > ds = new ArrayList<>();
        for ( int i = 0 ; i < nums.length ; i++ ) {
          ds.add(nums[i]);
        }
          res.add(new ArrayList<>(ds));
        return;
      }

      for ( int i = 0 ; i < nums.length ; i++ ) {
          swap(nums, i, index);
          OptimizedFindPermutations(nums, res, index + 1);
          swap(nums, i, index);              
      }
  }

   public static void findPermutations(int[] nums, List < Integer > ds, List < List < Integer > > res, boolean[] check ) {
       if ( ds.size() == nums.length ) {
         res.add(new ArrayList<>(ds));
         return;
       }

       for ( int i = 0 ; i < nums.length ; i++ ) {
          if ( !check[i] ) {
              check[i] = true;
              ds.add(nums[i]);
              findPermutations(nums, ds, res, check);
              ds.remove(ds.size() - 1);
              check[i] = false;
          }
       }
   }

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int nums[] = new int[n];
      for (int i = 0 ; i < n ; i++ ) {
        nums[i] = sc.nextInt();
      }

      List < Integer > ds = new ArrayList<>();
      List < List < Integer > > res = new ArrayList<>();
      

      findPermutations(nums, ds, res, new boolean[n]);
      
      for ( List < Integer > list : res ) {
        for ( int e : list ) {
           System.out.print(e + " ");
        }
        System.out.println();
      }

   }

}
