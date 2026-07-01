// class Solution {
//     public int numRescueBoats(int[] people, int limit) {
//         Arrays.sort(people);

//         int boat = 0;
//         int sum = 0;

//         for (int i = 0; i < people.length; i++) {
//             if (sum + people[i] > limit) {
//                 boat++;
//                 sum = people[i];
//             } else {
//                 sum += people[i];
//             }
//         }

//         if (sum > 0) {
//             boat++;
//         }

//         return boat;
//     }
// }It will fail is test case 



// Optimal method 
// Always place the heaviest person in a boat, and pair them with the lightest person only if they fit; otherwise, the heaviest must go alone.

//Approch:- Two pointer

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        int boats=0;
        while(left<=right){
            if(people[left]+people[right]<=limit) left++;

            right--;
            boats++;
        }
        return boats;

    }
}    