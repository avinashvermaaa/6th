// problem link :- https://leetcode.com/problems/jump-game-ii/
// avinash_verma
//code chef :- avinash_vermaa
//github : -   avinash_vermaaa

class Solution {
public:

    int jump(vector<int>& nums) {

      for(int i = 1; i < nums.size(); i++)
      {
        nums[i] = max(nums[i] + i, nums[i-1]);
      }

      long long int index = 0,ans = 0;

      while(index < nums.size() - 1)
      {
        ans++;
        index = nums[index];
      }

      return ans;
    }
};
