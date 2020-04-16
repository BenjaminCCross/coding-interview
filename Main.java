import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args){
        int[] small = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] big = new int[100];
        SortingAndSearching s = new SortingAndSearching();

        for (int i = 0; i < big.length; i++) {
            big[i] = i;
          }
          int[] sample = big;
          System.out.println("Before Scramble");
          print(sample);
          scramble(sample);
          System.out.println("After Scramble");
          print(sample);
          System.out.println("After sort");
          print(s.mergeSort(sample));
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
      }
    
      public static void scramble(int[] arr) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = arr.length - 1; i > 0; i--) {
          int index = rnd.nextInt(i + 1);
          int a = arr[index];
          arr[index] = arr[i];
          arr[i] = a;
        }
      }
}