// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int ar[]=new int[2];
//         for(int i=0;i<numbers.length-1;i++){
//             for(int j=i+1;j<numbers.length;j++){
//                 if(numbers[i]+numbers[j]==target){
//                     ar[0] = i + 1;
//                     ar[1] = j + 1;
//                     return ar;
//                 }
//             }
//         }
//         return ar;
//     }
// }
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;int j=numbers.length-1;
        while(i<j){
            int sum=numbers[i]+numbers[j];
            if(sum==target){
                return new int[]{i+1,j+1};
            }
            else if(sum<target){
                i++;
            }
            else{
                j--;
            }
        }
        return new int[]{};
    }
}
