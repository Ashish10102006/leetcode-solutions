// class Solution {
//     public int reverseBits(int n) {

//         String binary_of_n = decimalToBinary(n);

//         // ensure 32 bits
//         while (binary_of_n.length() < 32) {
//             binary_of_n = "0" + binary_of_n;
//         }

//         String reversed = new StringBuilder(binary_of_n).reverse().toString();

//         return binaryToDecimal(reversed);
//     }

//     public String decimalToBinary(int n) {
//         if (n == 0) return "0";

//         StringBuilder sb = new StringBuilder();

//         while (n > 0) {
//             sb.append(n % 2);
//             n = n / 2;
//         }

//         return sb.reverse().toString();
//     }

//     public int binaryToDecimal(String binary) {
//         int result = 0;

//         for (int i = 0; i < binary.length(); i++) {
//             result = result * 2 + (binary.charAt(i) - '0');
//         }

//         return result;
//     }
// }

// 🧾 Binary → Decimal (Simple Note)
// ✅ Rule:
// 👉 Start from 0
// 👉 For each binary digit:
// result = result * 2 + digit


// You already know decimal (base 10):
// Example: building number 123
// Step-by-step:
// Start: 0
// 0 × 10 + 1 = 1
// 1 × 10 + 2 = 12
// 12 × 10 + 3 = 123

 class Solution {
    public int reverseBits(int n) {
        int result=0;
        for(int i=0;i<32;i++){
            int lsb=n&1;
            int reverse_lsb=lsb << (31-i);
            result=result | reverse_lsb;
            n=n >>1;
        }
        return result;
    }
}