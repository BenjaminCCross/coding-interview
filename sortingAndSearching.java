import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class sortingAndSearching {
  public static int[] small = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
  public static int[] big = new int[100];
  public static void main(String[] args) {
    for (int i = 0; i < big.length; i++) {
      big[i] = i;
    }

    // scramble(small);
    // System.out.println("Selection");
    // selection(small);
    // print(small);
    //
    // scramble(small);
    // System.out.println("Insertion");
    // insertion(small);
    // print(small);
    //
    // scramble(small);
    // System.out.println("mergeSort");
    // mergeSort(small, 0, small.length - 1);
    // print(small);
    //
    // scramble(small);
    // System.out.println("quick");
    // quick(small, 0, small.length - 1);
    // print(small);

    scramble(small);
    System.out.println("quick");
    heap(small);
    print(small);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
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

  public static void selection(int arr[]) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      int min_idx = i;
      for (int j = i + 1; j < n; j++)
        if (arr[j] < arr[min_idx])
          min_idx = j;
      int temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;
    }
  }

  public static void insertion(int arr[]) {
    int n = arr.length;
    for (int i = 1; i < n; ++i) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
  }

  public static void merge(int arr[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[] = new int[n1];
    int R[] = new int[n2];

    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];
    int i = 0, j = 0;

    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  public static void mergeSort(int arr[], int l, int r) {
    if (l < r) {
      int m = (l + r) / 2;

      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);

      merge(arr, l, m, r);
    }
  }

  public static int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {

      if (arr[j] <= pivot) {
        i++;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }

  public static void quick(int arr[], int low, int high) {
    if (low < high) {

      int pi = partition(arr, low, high);

      quick(arr, low, pi - 1);
      quick(arr, pi + 1, high);
    }
  }

  public static void heap(int arr[]) {
    int n = arr.length;

    for (int i = n / 2 - 1; i >= 0; i--)
      heapify(arr, n, i);

    for (int i = n - 1; i >= 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr, i, 0);
    }
  }

  public static void heapify(int arr[], int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[largest])
      largest = l;

    if (r < n && arr[r] > arr[largest])
      largest = r;

    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      heapify(arr, n, largest);
    }
  }

  class Node {
    int key;
    Node left, right;

    public Node(int item) {
      key = item;
      left = right = null;
    }
  }

  // Root of BST
  Node root;

  // Constructor
  GFG() { root = null; }

  // This method mainly
  // calls insertRec()
  void insert(int key) { root = insertRec(root, key); }

  /* A recursive function to
  insert a new key in BST */
  Node insertRec(Node root, int key) {

    /* If the tree is empty,
    return a new node */
    if (root == null) {
      root = new Node(key);
      return root;
    }

    /* Otherwise, recur
    down the tree */
    if (key < root.key)
      root.left = insertRec(root.left, key);
    else if (key > root.key)
      root.right = insertRec(root.right, key);

    /* return the root */
    return root;
  }

  // A function to do
  // inorder traversal of BST
  void inorderRec(Node root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.print(root.key + " ");
      inorderRec(root.right);
    }
  }
  void treeins(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      insert(arr[i]);
    }
  }
}
