package Recursion.CombinationSum.Java;
import java.util.*;

public class CombinationSum {
    
    public static void subsequences(int[] nums, List < List<Integer> > res, List < Integer> ds, int target, int index) {
        if ( index == nums.length ) {
          if ( target == 0 ) {
              res.add(new ArrayList<>(ds));
          }
          return ;
        }
      if ( nums[index] <= target ) {
          ds.add(nums[index]);
          subsequences(nums, res, ds, target - nums[index], index);
          ds.remove(ds.size() - 1);
      }  
      subsequences(nums, res, ds, target, index + 1);
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
      List < List <Integer> > res = new ArrayList <> ();
      List < Integer > ds = new ArrayList<>();
      subsequences(candidates, res, ds, target, 0);
      return res;
  }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] values = new int[sc.nextInt()];
        for ( int i = 0 ;  i < values.length ; i++ ) {
            values[i] = sc.nextInt();
        }
      List < List < Integer > > res = combinationSum(values, target);
      for ( List < Integer > list : res ) {
         for ( int ele : list ) {
            System.out.print(ele + " ");
         }
         System.out.println();
       }
        sc.close();
    }
  
}
