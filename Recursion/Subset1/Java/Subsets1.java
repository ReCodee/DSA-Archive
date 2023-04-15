package Recursion.Subset1.Java;
import java.util.*;

public class Subsets1 {
    public static void findSubsets(int[] nums, List < Integer > ds, List < List < Integer > > res, int index) {
        if ( index == nums.length ) {
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        findSubsets(nums, ds, res, index + 1);
        ds.remove(ds.size() - 1);
        findSubsets(nums, ds, res, index + 1);
    }

    public static List<List<Integer>> subsets(int[] nums) {
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
         res = subsets(nums);
        for ( List < Integer > list : res ) {
          for ( int e : list ) {
             System.out.print(e + " ");
          }
          System.out.println();
        }  
    }
}
