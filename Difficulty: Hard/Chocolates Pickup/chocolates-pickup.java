//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int solve(int n, int m, int grid[][]) {
        // Code here
       
        int dp[][][] = new int[n][m][m] ;
        
        for(int j1 = 0 ; j1 < m ; j1++){
            
            for(int j2 = 0 ; j2 < m ; j2++){
                
                if(j1==j2)
                    dp[n-1][j1][j2] = grid[n-1][j1] ;
                else
                     dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2] ;
                
            }
        }
        
        for(int r = n-2 ; r>=0 ; r--){
            for(int c1 = 0 ; c1<m ; c1++){
                for(int c2=0 ; c2 <m ; c2++){
                    
                    int max = 0 ;
                    for(int i = c1 -1 ; i <= c1 + 1 ; i++){
                        for(int j = c2-1 ; j<= c2 + 1 ; j++){
                            
                            if(i>=0 && j>=0 && i<m && j<m){
                                if(c1==c2)
                                    max =  Math.max( max , grid[r][c1] + dp[r+1][i][j]) ;
                                else
                                    max = Math.max( max , grid[r][c1] + grid[r][c2] +  dp[r+1][i][j] ) ;
                            }
                        }
                        
                    }
                    
                    dp[r][c1][c2] = max ;
                    
                }
            }
        }
   
        
        return dp[0][0][m-1] ;
    }
    
    // public int helper(int n , int m , int grid[][] ,int r , int c1 , int c2 , int[][][] dp){
        
    //     if(r == n-1){
    //         if(c1==c2)
    //             return grid[r][c1] ;
    //         else
    //             return grid[r][c1] + grid[r][c2] ;
    //     }
        
    //     if(dp[r][c1][c2] != 0)
    //         return dp[r][c1][c2] ;
        
    //     int max = 0 ;
    //     for(int i = c1 -1 ; i <= c1 + 1 ; i++){
    //         for(int j = c2-1 ; j<= c2 + 1 ; j++){
                
    //             if(i>=0 && j>=0 && i<m && j<m){
    //                 if(c1==c2)
    //                     max =  Math.max( max ,grid[r][c1] + helper( n , m , grid , r+1 ,i , j , dp));
    //                 else
    //                     max = Math.max( max , grid[r][c1] + grid[r][c2] +  helper( n , m , grid , r+1 ,i , j , dp));
    //             }
    //         }
            
    //     }
        
    //     return dp[r][c1][c2] = max ;
    // }
}