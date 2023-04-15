package Recursion.PrintAllSubsequences.Java;
import java.util.*;

public class PrintAllSubsequences {

    static void printAllSubsequences(List<Integer> arr, List<Integer> storage, int index) {
        if ( index >= arr.size() ) {
            for(int e : storage) {
                System.out.print(e + " ");
            }
            System.out.println();
          return;
        }
        
        storage.add(arr.get(index));
        printAllSubsequences(arr, storage, index + 1);
        storage.remove(arr.get(index));
        printAllSubsequences(arr, storage, index + 1);
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> input = new ArrayList<Integer>();
        List<Integer> storage = new ArrayList<Integer>();
        while(n > 0) {
            n--;
             input.add(sc.nextInt());
        }
        printAllSubsequences(input, storage, 0);
    }
}
