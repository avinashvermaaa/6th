// problem link :- https://leetcode.com/problems/3sum/
// avinash_verma
//code chef :- avinash_vermaa
//github : -   avinash_vermaaa

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        long target = 0;
        set<vector<int>> s;
        vector<vector<int>> output;
        for (long i = 0; i < nums.size(); i++){
            long left = i + 1;
            long right = nums.size() - 1;
            while (left < right) {
                long sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    s.insert({nums[i], nums[left], nums[right]});
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        for(auto expo : s)
            output.push_back(expo);
        return output;
    }
};
