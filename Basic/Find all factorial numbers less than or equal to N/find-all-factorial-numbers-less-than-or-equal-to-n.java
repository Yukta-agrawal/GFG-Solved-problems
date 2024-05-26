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
            long N=sc.nextLong();
			
            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for(long num : ans){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Long> factorialNumbers(long N){
        // code here
             ArrayList<Long> ans = new ArrayList<>();
        helper(N, 1, 1, ans);
        return ans;
    }
    
    public static void helper(long N, long factorial, long count, ArrayList<Long> ans) {
        if (factorial > N) {
            return;
        }
        
        ans.add(factorial);
        helper(N, factorial * (count + 1), count + 1, ans);

        
    }
    
}