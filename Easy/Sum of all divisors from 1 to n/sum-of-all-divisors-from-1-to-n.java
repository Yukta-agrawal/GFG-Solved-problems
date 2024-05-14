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
            int N=sc.nextInt();
            Solution ob = new Solution();
            long ans  = ob.sumOfDivisors(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution{
    static long sumOfDivisors(int N){
        // code here
        long sum = 0 ;
        
        for(int i= 1 ; i<= N ; i++){
              sum += (N/i)*i ;               
        }
        return sum;
    }
}
//User function Template for Java
// class Solution{
//     static long sumOfDivisors(int N){
//         // code here
//         long sum1 = 0 ;
//         while(N!=0){
//             long sum = 0 ;
//             for(int i= 1 ; i*i<= N ; i++){
//                 if(N%i == 0){
//                     if( i*i != N){
//                         sum= sum + i + (N/i) ;
//                     }else{
//                         sum += i ;
//                     }
//                 }
//             }
//             sum1+=sum ;
//             N--;
//         }
        
        
//         return sum1;
//     }
// }