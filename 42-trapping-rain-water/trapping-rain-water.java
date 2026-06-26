// 🚀 Best approach: Two Pointers (O(n), O(1))
// leftmax=👉 tallest bar we have seen from the left side so far
// rightmax=👉 tallest bar we have seen from the right side so far
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int leftmax=0;//👉 “We have not seen any bars yet, so the maximum height so far is 0.”
        int rightmax=0;//👉 “We have not seen any bars yet, so the maximum height so far is 0.”
        int water=0;
        while(left<right){
            if(height[left] < height[right])  {
                  if (height[left] > leftmax){
                    leftmax = height[left];
                  }
                  else{
                    water+=leftmax-height[left];
                  }
                left++;
            }
            else{
                if(height[right]> rightmax){
                    rightmax=height[right];
                }
                else{
                     water+=rightmax-height[right];
                }
                right--;
            }
        }
        return water;

    }
}


// ⚡ Alternative approach (also valid but not best)
// 1. Prefix + Suffix arrays (easy to understand)
// leftMax[]=>leftMax[i] = tallest bar from 0  i
// rightMax[]=>rightMax[i] = tallest bar from end  → 0
// water[i] = min(leftMax[i], rightMax[i]) - height[i]

// But:
// ❌ extra space O(n)