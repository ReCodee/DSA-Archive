package Recursion.Subset2.Java;
import java.util.*;

public class Subset2 {
    public static void findSubsets(int[] nums, List < Integer > ds, List < List < Integer > > res, int index) {
        res.add(new ArrayList<>(ds));
        for ( int i = index ; i < nums.length ; i++ ) {
           if ( i != index && nums[i - 1] == nums[i] ) continue;
           ds.add(nums[i]);
           findSubsets(nums, ds, res, i + 1);
           ds.remove(ds.size() - 1);
        }
   }

   public static List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
       List < Integer > ds = new ArrayList<>();
       List < List < Integer > > res = new ArrayList<>();
       findSubsets(nums, ds, res, 0);
       return res;
   }

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] nums = new int[n];
       for ( int i = 0 ; i < n ; i++ ) {
         nums[i] = sc.nextInt();
       }
       List < List < Integer > > res = new ArrayList<>();
        res = subsetsWithDup(nums);
       for ( List < Integer > list : res ) {
         for ( int e : list ) {
            System.out.print(e + " ");
         }
         System.out.println();
       }  
   }
}
