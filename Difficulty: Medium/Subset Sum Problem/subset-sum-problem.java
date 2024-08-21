//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp = new int[N][sum+1] ;
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        int r=helper(N-1 , arr , sum , dp);
        if(r==0){
            return false;
        }
        else{
            return true;
        }
        
    }
    
    public static int helper(int index , int arr[], int sum , int[][] dp ){
        
        if(index==0){
            if(arr[0]==sum)
                return 1 ;
            else
                return 0;
        }
        
        if(sum==0){
            return 1;
        }
        
        if(dp[index][sum] != -1){
            return dp[index][sum];
        }
        
        
        
        int nottake = helper(index-1 , arr , sum ,dp );
        int take =0;
        if(sum-arr[index]>=0) take = helper(index-1 , arr , sum-arr[index], dp);
        
        
        dp[index][sum] = (take | nottake) ;
        return dp[index][sum];
    }
}