
# Round 511

In this round I answered 1 question and did not attempt anymore. It passed the pretests but not the final system test.

## Little C Loves 3 I

I looked through the sample input and output and found a pattern that divided the scanned in integer by three. From the problem though I knew that I had to make sure the three numbers that added up to the scanned in number was not a multiple of three. So I made a while loop that'll continue running until none of the three numbers were no longer a multiple of three. I kept adding and subtracting from each number each run. The pretest passed, but the system check failed because I found out that some test cases generated negative numbers and they can't be negative.

http://codeforces.com/contest/1047/standings/friends/true
