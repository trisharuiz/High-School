
# Round 519

In this round I answered 1 question and did not attempt anymore.

## Problem A - Elections

To solve the problem the first thing I did was to scan all the vote numbers into an array, and I had to find the max since it would be the minimum number of votes Awruk would need. To find the max I used Array.sort and stored the last value into an integer. Once find the max I used that number as a starting number to subtract Elodreip's votes from to add together to find Awruk's votes. It would keep finding the sum through a number of operations until Awruk's sum is greater than Elodreip's score. Once it is I printed out that number.

http://codeforces.com/contest/1043/standings/friends/true
