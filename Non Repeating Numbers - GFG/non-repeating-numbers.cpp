//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
public:
    vector<int> singleNumber(vector<int> nums) 
    {
        // Code here.
        int Xor =0;
        for(int i=0;i<nums.size();i++){
            Xor ^= nums[i];
        }
        //find a set bit of xor
        int pos = 0;
        int temp = Xor;
        while((temp & 1) == 0){
            pos++;
            temp = temp>>1;
        }
 
        int res1 =0 ;
        int res2 =0;
        int mask = 1<<pos;
        for(int i = 0;i<nums.size();i++){
            if((nums[i] & mask) > 0){
                res1 ^= nums[i];
            }
            else{
                res2 ^= nums[i];
            }
            
        }
        if(res1>res2)return {res2,res1};
        else return {res1,res2};
    }
};

//{ Driver Code Starts.
int main(){
    int T;
    cin >> T;
    while(T--)
    {
    	int n; 
    	cin >> n;
    	vector<int> v(2 * n + 2);
    	for(int i = 0; i < 2 * n + 2; i++)
    		cin >> v[i];
    	Solution ob;
    	vector<int > ans = ob.singleNumber(v);
    	for(auto i: ans)
    		cout << i << " ";
    	cout << "\n";
    }
	return 0;
}
// } Driver Code Ends