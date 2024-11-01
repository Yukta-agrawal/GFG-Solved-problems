//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}


// } Driver Code Ends

//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        //code here
        int[] dp = new int[N];
        Arrays.fill(dp , -1);
        
        return helper(N-1 ,arr , dp);
        
    }
    
    public int helper(int i ,int arr[] , int[] dp){
        
        if(i==0){
            return 0;
        }
        if(i==1){
            return Math.abs(arr[1]-arr[0]);
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        
        int one = helper(i-1 , arr , dp) + Math.abs(arr[i] - arr[i-1]) ;
        int two = helper(i-2 , arr , dp) + Math.abs(arr[i] - arr[i-2]);
        
        return dp[i] = Math.min(one , two);
    }
}