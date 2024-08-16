//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        int n = s.length();
        List<String> ans = new ArrayList<>();
       String s1 = "";
        helper(0 , ans , s , s1);
        
        Collections.sort(ans);
        return ans;
    }
    
    
     public void helper(int index , List<String> ans , String s ,String s1){
         
        if(index == s.length()){
            if(s1!="") ans.add(s1);
            return;
        }
        

        //take
    
        helper(index+1 , ans , s , s1 + s.charAt(index));
       
        
        //not take
        helper(index+1 , ans , s , s1);
        
        
    }
}