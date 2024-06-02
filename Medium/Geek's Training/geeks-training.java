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
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int maximumPoints(int points[][],int N){
        
        int[][] dp = new int[N][4] ;
         for (int[] row : dp)
            Arrays.fill(row, -1);
        
        return helper(N-1 , 3, points , dp);
    }
    
    public int helper(int n, int last , int[][] points , int[][] dp){
     
        if(n<0){
            return 0 ;
        }
        
        
         if(dp[n][last] != -1){
            return dp[n][last] ;
        }
        
        int sum = 0 ;
        
        for( int j = 0 ; j< 3 ; j++){
            if(j!=last){
                
                    int sum1 = points[n][j] + helper(n-1 , j , points , dp);
                    sum = Math.max(sum , sum1 ) ;
                }
               
            }
            
         dp[n][last] = sum ;
         
         return dp[n][last];
    }
}