//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {   //Greedy Approach
    
        //first sort take the 2 d array
        int meeting[][] = new int[n][3];
        //store
        for(int i=0; i<n; i++){
            meeting[i][0] = i+1;
            meeting[i][1] = start[i];
            meeting[i][2] = end[i];
        }
        
        //SORT THE MEETING ARRAY USING JAVA COMPARATOR LAMBDA FUNTION
        Arrays.sort(meeting,Comparator.comparingDouble(o -> o[2]));
        
        int maximum = 0;
        ArrayList<Integer> A = new ArrayList<>();
        maximum = 1;
        A.add(meeting[0][0]);
        
        int Lastend = meeting[0][2];
        
        for(int i = 1; i<n; i++){
            if(meeting[i][1] > Lastend){
                maximum++;
            A.add(meeting[i][0]);
            //update the lastend 
            Lastend = meeting[i][2];
            }

        }
        
        return maximum;
        // add your code here
    }
}
