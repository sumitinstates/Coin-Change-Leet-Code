package com.sumit;

import java.util.Arrays;

public class Solution {
	
	public static int coinChange(int[] coins, int amount) {
        
		Arrays.sort(coins);
		
		int [] dp = new int[amount+1];
		
		//fill the array with amount+1. So all its indexes will now have amount+1 value in beginning.
		Arrays.fill(dp, amount+1);
		
		/*
		 * coins needed to make 0$ will always be 0. Also, index of dp[] array is the amount. 
		 * And Value in that index is the minimum coins needed to make that amount.
		 * 
		 */
		dp[0]=0;
		
		for(int i = 0; i<=amount; i++) 
		{
			for(int j=0 ; j<coins.length; j++) 
			{
				
				/*
				 * amount value should always be less or equal to coin. For example,
				 * if current coin we are going to use is 5$, but the amount we have
				 * to make is 4$, then it won't make sense, as we can never make 4$ amount
				 * with 5$ coin.
				 * 
				 */
				if(i>=coins[j]) 
				{
					dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
				}
			}
		}
		
		return dp[amount] > amount ? -1 : dp[amount];
		
		
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,5};
		int amount = 11;
		System.out.println(Solution.coinChange(arr1, amount));
	}

}
