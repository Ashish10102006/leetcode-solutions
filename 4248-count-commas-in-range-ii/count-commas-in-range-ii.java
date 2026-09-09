class Solution {
    public long countCommas(long n) {
        long count = 0;
        long power = 1000;

        while (power <= n) {
            count += n - power + 1;
            power *= 1000;
        }

        return count;
    }
}
/*
power means:

power = 1000

Count numbers having the 1st comma.

Then:

power = 1,000,000

Count numbers having the 2nd comma.

Then:

power = 1,000,000,000

Count numbers having the 3rd comma.

And so on.

The trick to discover these problems

Don't immediately think about code.

First make a table:

Range                  Extra comma
1000+                  1
1,000,000+             2
1,000,000,000+         3
1,000,000,000,000+     4

Then ask:

"How many numbers are in each range?"

That gives:

n - 1000 + 1
n - 1000000 + 1
n - 1000000000 + 1
...

which simplifies to:

n - power + 1
*/