// class Solution {
//     public boolean isHappy(int n) {
//         Set<Integer> set = new HashSet<>();
//         while(n!=1){
//             if(set.contains(n)) return false;
//             set.add(n);
//             n=sumOfSquare(n);
//         }
//         return true;
//     }
//     public int sumOfSquare(int n){
//         int sum=0;
//         while(n!=0){
//             int digit=n%10;
//             sum+=digit*digit;
//             n/=10;
//         }
//         return sum;
//     }
// }
import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    private int getNext(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;      // Last digit
            sum += digit * digit;    // Square and add
            n /= 10;                 // Remove last digit
        }

        return sum;
    }
}
// Keep generating the sum of squares of digits. If you reach 1, it's happy. If a number repeats, you're in a cycle, so it's not happy.