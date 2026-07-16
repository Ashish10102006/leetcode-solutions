//1st-approch-optimal
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int studentCountZeroes=0;
        int studentCountOnes=0;
        for(int no:students){
            if(no==1)studentCountOnes++;
            else studentCountZeroes++;
        }
        for(int s:sandwiches){
            if(s==1){
                if(studentCountOnes>0)studentCountOnes--;
                else break;
            }
            else{
                if(studentCountZeroes>0)studentCountZeroes--;
                else break;
            }
        }
        return studentCountZeroes + studentCountOnes;

    }
}
/*
//2nd-approch
import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();

        for (int student : students) {
            queue.offer(student);
        }

        int i = 0;          // Index of top sandwich
        int rotations = 0;  // Number of consecutive students moved to the back

        while (!queue.isEmpty() && rotations < queue.size()) {
            if (queue.peek() == sandwiches[i]) {
                queue.poll();   // Student eats
                i++;            // Next sandwich
                rotations = 0;  // Reset because someone ate
            } else {
                queue.offer(queue.poll()); // Move student to the back
                rotations++;
            }
        }

        return queue.size();
    }
}
*/