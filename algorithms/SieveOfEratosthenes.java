/* per lecture 5
 */


public static void printPrimes(int n) {
  boolean [] prime = new boolean[n + 1];

  int i;
  for(i = 2; i <= n; i++) {
    prime[i] = true;
  }

  for(int divisor = 2; divisor * divisor <= n; divisor++) {
    if(prime[divisor]) {
      for(i = 2 * divisor; i <= n; i += divisor) {
        prime[i] = false;
      }
    }
  }

  for(i = 2; i <= n; i++) {
    if(prime[i]) {
      system.out.print(" " + i);
    }
  }

}
