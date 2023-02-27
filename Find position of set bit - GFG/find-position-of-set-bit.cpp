//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    int findPosition(int N) {
        // code here
     int count=0;
     int pos = 0;
    int pos1;
     while(N>0){
      if((N&1) == 0){
          pos++;
      }
      else{
          count++;
          pos1 = pos+1;
      }
     N= N>>1;
     }
     if(count>1 || count==0)return -1;
     return pos1;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;

        cin>>N;

        Solution ob;
        cout << ob.findPosition(N) << endl;
    }
    return 0;
}
// } Driver Code Ends