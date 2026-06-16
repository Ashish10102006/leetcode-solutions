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
class Solution {
    public int getNext(int n){
        int sum = 0;
        while(n != 0){
            int digit = n % 10;
            n = n / 10;

            sum += Math.pow(digit,2);
        }
        return sum;
    }

    public boolean isHappy(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();

        while(true){
            //add element to map
            map.put(n,0);
            n = getNext(n); //update next

            //now check whether n is in map or n is 1 
            if(n == 1)  return true;
            if(map.containsKey(n))  return false;
        }
    }   
}
// Keep generating the sum of squares of digits. If you reach 1, it's happy. If a number repeats, you're in a cycle, so it's not happy.