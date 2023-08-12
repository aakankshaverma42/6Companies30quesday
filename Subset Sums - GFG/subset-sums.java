//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    
    static void SubsetCall(int i, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> Subset){
        //base case
        if(i == N){
           Subset.add(sum);
           return ;
        }
        
        //backtracing 
        //left
        //selecting the index value
        SubsetCall(i+1,sum + arr.get(i),arr,N,Subset);
        //right
        //not selecting the index value
        SubsetCall(i+1,sum,arr,N,Subset);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        //take a new arraylist
        ArrayList<Integer> Subset = new ArrayList<>();
        
        //recursive call
        SubsetCall(0,0,arr,N,Subset);
        
        //after whole subset stored in Subset sort the array
        
        Collections.sort(Subset);
        
        return Subset;
        
    }
}