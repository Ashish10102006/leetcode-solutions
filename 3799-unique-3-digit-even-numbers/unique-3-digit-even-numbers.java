class Solution {
    public int totalNumbers(int[] digits) {

        int size = digits.length;
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < size; i++) {

            if (digits[i] == 0) continue;

            for (int j = 0; j < size; j++) {

                if (i == j) continue;

                for (int k = 0; k < size; k++) {

                    if (i == k || j == k) continue;

                    if (digits[k] % 2 != 0) continue;

                    int num = digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    result.add(num);
                }
            }
        }

        return result.size();
    }
}