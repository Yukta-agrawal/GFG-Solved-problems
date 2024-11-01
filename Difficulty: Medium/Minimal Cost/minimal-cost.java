//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int dp[] = new int[arr.length];
        dp[0] =  0;
        for(int i=1 ;  i<arr.length ; i++){
            int min = (int)10e9 ;
            for(int j = 1 ; i-j>=0 && j<=k ; j++){
                min = Math.min( min , dp[i-j] + Math.abs(arr[i] - arr[i-j]) );
            }
           dp[i] = min;
        }
        return dp[arr.length-1] ;
    }
    
    public int helper(int i , int k, int arr[] , int[] dp){
        
        if(i==0){
            return 0;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        
        int min = (int)10e9 ;
        for(int j = 1 ; i-j>=0 && j<=k  ; j++){
            min = Math.min(min , helper(i-j , k , arr , dp) + Math.abs(arr[i] - arr[i-j]));
        }
        
        return dp[i] = min;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends