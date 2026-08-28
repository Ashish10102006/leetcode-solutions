// 1st way=hashmap
/*
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int no:nums){
            map.put(no,map.getOrDefault(no,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>(n/3))result.add(key);
        }

        return result;
    }
}
/*
More than n/2 → maximum 1 element

More than n/3 → maximum 2 elements

More than n/k → maximum k-1 elements
*/

//2nd way =moores vooting process

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;

        int candidate1=0;
        int candidate2=0;

        int count1=0;
        int count2=0;


        // Step 1: Find possible candidates
        for(int i:nums){
            if (count1 == 0 && i != candidate2) {
                candidate1 = i;
            }
            else if (count2 == 0 && i != candidate1) {
                candidate2 = i;
            }

            if (i == candidate1) {
                count1++;
            }
            else if (i == candidate2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }    
        }

        // Step 2: Verify candidates
        count1=0;
        count2=0;

        for (int i : nums) {
            if (i == candidate1) {
                count1++;
            }
            else if (i == candidate2) {
                count2++;
            }
        }

        // Step 3: Add valid candidates
        List<Integer> result = new ArrayList<>();

        if (count1 > n / 3) {
            result.add(candidate1);
        }

        if (count2 > n / 3) {
            result.add(candidate2);
        }

        return result;

    }
}        