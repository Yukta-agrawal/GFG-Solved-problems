//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int MOD = (int)(1e9 + 7);
    public static int countPartitions(int n, int d, int[] arr) {
        
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int summation = (sum - d)/2 ;
        if((sum-d)%2 != 0 || (sum-d)<0){
            return 0;
        }
        
        int dp[][] = new int[n][summation+1];
        
        for(int row[]: dp){
            Arrays.fill(row , -1);
        }
        
        return helper(n-1 , summation , arr , dp)%MOD;
        
    }
    
    public static int helper(int index ,int summation , int[] arr, int[][] dp){
        
        if(index==0){
            
            if(summation==0 && arr[0]==0) return 2;
            if(summation==0 || arr[0]==summation) return 1;
            return 0;
        }
        
        if(dp[index][summation]!= -1){
            return dp[index][summation];
        }
        int nottake = helper(index -1 , summation , arr, dp) % MOD;
        int take = 0 ;
        if(arr[index]<=summation){
            take = helper(index-1 ,summation - arr[index] , arr , dp) %MOD;
        }
        
        return dp[index][summation]= (take + nottake)%MOD;
        
    }
}
        
