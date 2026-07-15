class Solution {
    public String reverseVowels(String s) {
        char arr[]=s.toCharArray();
        int i=0;
        int j=arr.length - 1;
        while(i<j){
           while (i < j && !isVowel(arr[i])) i++;
           while (i < j && !isVowel(arr[j])) j--;
            if(i<j){
                swap(i,j,arr);
                i++;
                j--;
            }
        }
        return new String(arr);
    }
    public boolean isVowel(char c){
        return "AEIOUaeiou".indexOf(c) !=-1;
    }
    public void swap(int i,int j, char arr[]){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}