public class fibonacci {
  public static void main(String[] args) {
    int n = 10;
    // Check how many arguments were passed in
    if (args.length == 0) {
      System.out.println("Proper Usage is: java fibonacci n");
      System.exit(0);
    } else {
      n = Integer.parseInt(args[0]);
    }

    for (int i = n; i >= 0; i--) {
      System.out.println(iterative(i));
    }

    for (int i = n; i >= 0; i--) {
      System.out.println(recursive(i));
    }

    for (int i = n; i >= 0; i--) {
      System.out.println(topDynamic(i));
    }

    for (int i = n; i >= 0; i--) {
      System.out.println(botDynamic(i));
    }
  }
  public static int iterative(int n) {
    if (n <= 1) {
      return n;
    }
    int fib = 1;
    int prevFib = 1;

    for (int i = 2; i < n; i++) {
      int temp = fib;
      fib += prevFib;
      prevFib = temp;
    }
    return fib;
  }

  /*
    Recursive implementation for the fibonacci sequence. Each call is only O(1)
    work outside it's call, therefore, the number of calls is the runtime.
    Beacuse each call has 2 recursive calls (outside the base case), therfore
    this algorithm runs roughly in O(2^n) time. Technically it is closer to
    something like O(1.6^n) because the left tree will always be slightly large
    than the right tree of calls. Either way though, it expnentiated time is
    pretty crap
  */
  public static int recursive(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return recursive(n - 1) + recursive(n - 2);
    }
  }

  /*
    Top-Down Dynamic Programming interpretation of the fibonacci sequence. This
    is a significantly more efficient solution as it is not repeating work the
    same way the recursive solution operates. As all solutions are held in an
    array, the algorithm does not need to resolve the same problem it solved a
    few cycles prior. This gives us a run time of O(n).
  */
  public static int topDynamic(int n) { return topDynamic(n, new int[n + 1]); }
  public static int topDynamic(int n, int[] memo) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }

    if (memo[n] == 0) {
      memo[n] = topDynamic(n - 1, memo) + topDynamic(n - 2, memo);
    }
    return memo[n];
  }
  /*
    Bottom-Up Dynamic Programming interpretation of the fibonacci sequence.
    Similarly to the Top-Down strategy it is significantly more efficient,
    however does not require any recursive calls. It is effectively acting as a
    less space efficient version of the iterative algorithm as every n-m>0 value
    is stored uniquely. This is unnessary as none of these values will be called
    again.
  */
  public static int botDynamic(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }
    int[] memo = new int[n];
    memo[0] = 0;
    memo[1] = 1;
    for (int i = 2; i < n; i++) {
      memo[i] = memo[i - 1] + memo[i - 2];
    }

    return memo[n - 1] + memo[n - 2];
  }
}
