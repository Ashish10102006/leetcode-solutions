// "How many papers can I choose such that each chosen paper has at least that many citations?"
// That's exactly what the h-index measures.

// 🔥 Key takeaway
// Descending order → check citations[i] >= i+1
// Ascending order → check citations[i] >= n - i

// Both give same answer.
// class Solution {
//     public int hIndex(int[] citations) {
//         reverseArray(citations);
//         int result=0;
//         int n= citations.length;
//         for(int i=0;i<n;i++){
//             if(citations[i]>=i+1) result+=1;
//             else break;
//         }
//         return result;
//     }
//     public void reverseArray(int [] arr){
//         Arrays.sort(arr); // ascending
//         // reverse manually
//         for (int i = 0; i < arr.length / 2; i++) {
//             int temp = arr[i];
//             arr[i] = arr[arr.length - 1 - i];
//             arr[arr.length - 1 - i] = temp;
//         }
//     }
// }

// And H-index definition says:
// We need at least h papers having ≥ h citations
// So we are checking:
// citations[i] >= number of papers considered
// which becomes:
// citations[i] >= i + 1

// Why i + 1?
// Because:
// At index i = 0, we are considering 1 paper
// At index i = 1, we are considering 2 papers
// At index i = 2, we are considering 3 papers

// 1.We sort descending because:
// “We always want to pick the most cited papers first so we can maximize the chance of forming a valid h-index.”

// 2. We can stop early
// As soon as a paper fails, we know:
// further papers will only be smaller → so they will also fail
// So we avoid unnecessary checks.

// Frequency Counting (Bucket Method)
// bucket[i] = number of papers that have exactly i citations
// But there is a catch:
// If citations > n, we don’t need exact value
// We group all big values into bucket[n]

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];

        // Step 1: fill buckets
        for (int c : citations) {
            if (c >= n) {
                bucket[n]++;
            } else {
                bucket[c]++;
            }
        }

        // Step 2: compute H-index from right to left
        int papers = 0;

        for (int i = n; i >= 0; i--) {
            papers += bucket[i];
            
            if (papers >= i) //“Do we have at least i papers that have ≥ i citations?”
            {
                return i;
            }
        }

        return 0;
    }
}