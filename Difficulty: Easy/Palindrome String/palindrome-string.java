//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        // code here
       int n = S.length();
        char[] arr = S.toCharArray();  // Convert string to char array
        
        // Reverse the string using two-pointer approach
        for(int i = 0; i < n / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        
        // Convert the char array back to string
        String reversedS = new String(arr);
        
        // Compare reversed string with the original
        if(S.equals(reversedS)) {
            return 1;  // Palindrome
        } else {
            return 0;  // Not a palindrome
        }
        
    }
}