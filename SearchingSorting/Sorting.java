package SearchingSorting;

public class Sorting {
  public Sorting() {
  }

  public int[] selectionSort(int[] arr) {
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
    return arr;
  }

  public int[] insertionSort(int[] arr) {
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
    return arr;
  }

  public int[] mergeSort(int[] arr) {
    if (arr.length < 2) {
      return arr;
    }
    int mid = arr.length / 2;
    int[] leftSide = new int[mid];
    int[] rightSide = new int[arr.length - mid];

    // divide array into two smaller arrays
    for (int i = 0; i < mid; i++) {
      leftSide[i] = arr[i];
    }
    for (int i = mid; i < arr.length; i++) {
      rightSide[i - mid] = arr[i];
    }
    leftSide = mergeSort(leftSide);
    rightSide = mergeSort(rightSide);

    return merge(leftSide, rightSide);
  }

  private int[] merge(int[] leftSide, int[] rightSide) {
    int[] merged = new int[leftSide.length + rightSide.length];
    int i = 0, j = 0, k = 0;
    while (i < leftSide.length && j < rightSide.length) {
      if (leftSide[i] <= rightSide[j]) {
        merged[k++] = leftSide[i++];
      } else {
        merged[k++] = rightSide[j++];
      }
    }
    while (i < leftSide.length) {
      merged[k++] = leftSide[i++];
    }
    while (j < rightSide.length) {
      merged[k++] = rightSide[j++];
    }
    return merged;
  }
}