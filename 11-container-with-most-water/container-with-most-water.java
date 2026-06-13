class Solution {
    public int maxArea(int[] height) {
        int i= 0,j=height.length-1;
        int maxarea=0;
        while(i<j){
            int width=j-i;
            int h=Math.min(height[i],height[j]);
            int area=width*h;
            maxarea=Math.max(area,maxarea);
            if(height[i]<height[j]) i++;
            else j--;
        }
        return maxarea;

    }
}