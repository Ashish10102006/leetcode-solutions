class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(x == 0) return 0.0;
        if(x == 1) return 1.0;
        if(x == -1) return (n % 2 == 0) ? 1.0 : -1.0;

        long N = n;       // use long to handle Integer.MIN_VALUE
        if(N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1.0; // use double
        while(N > 0) {
            if(N % 2 == 1) {  // check current bit
                ans *= x;
            }
            x *= x;   // square x
            N /= 2;   // shift exponent
        }

        return ans;
    }
}
// 1. If n is even
// xⁿ = (xⁿ⁄²)²
// Example:
// 2¹⁰ = (2⁵)²
//      = 32²
//      = 1024

// 2. If n is odd
// xⁿ = x × xⁿ⁻¹
// Example:
// 2⁵ = 2 × 2⁴
// Then:
// 2⁴ = (2²)²


// The reason for:
// x *= x;
// N /= 2;
// comes from this math identity:
// xⁿ = (x²)ⁿ⁄²
// when n is even.