//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum =0;
         for(int i=0; i<N; i++){
            sum+=A[i];
            if(sum==K){
                ans = i+1;
            }
            
            if(map.containsKey(sum-K)){
                int l1 = map.get(sum-K);
                ans = Math.max(ans , i - l1 );
            }
            if(!map.containsKey(sum))
                map.put(sum , i);

         }
        
        return  ans;
        // int longest = 0;
        // int start =0;
        // int sum = 0;
        // for(int i=0; i<N; i++){
        //     sum+=A[i];
            
        //     while(sum>K){
        //         sum= sum-A[start];
        //         start++;
        //     }
        //     if(sum==K){
        //         longest  = Math.max(longest , i-start+1);
        //     }
        // }
        
        // return longest;
        
    }
    
    
    
    
}


