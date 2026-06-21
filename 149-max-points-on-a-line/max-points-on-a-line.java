import java.util.*;

class Solution {

    int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2) return n;

        int ans = 0;

        for (int i = 0; i < n; i++) {

            Map<String, Integer> map = new HashMap<>();
            int dup = 0;
            int max = 0;

            for (int j = i + 1; j < n; j++) {

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Duplicate point
                if (dx == 0 && dy == 0) {
                    dup++;
                    continue;
                }

                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;

                // Normalize slopes
                if (dx == 0) {
                    dy = 1;           // all vertical lines -> 0/1
                } else if (dy == 0) {
                    dx = 1;           // all horizontal lines -> 1/0
                } else if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                String slope = dx + "/" + dy;

                int count = map.getOrDefault(slope, 0) + 1;
                map.put(slope, count);

                max = Math.max(max, count);
            }

            ans = Math.max(ans, max + dup + 1);
        }

        return ans;
    }
}