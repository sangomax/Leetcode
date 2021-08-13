//
//  PartitionEqualSubsetSum416.swift
//  leetcode_swift
//
//  Created by Adriano Gaiotto de Oliveira on 2021-08-11.
//

import Foundation

class PartitionEqualSubsetSum416 {
    
    func canPartition(_ nums: [Int]) -> Bool {
        
        let total = nums.reduce(0, +)
        
        if total % 2 == 1 { return false }
        
        if nums.contains(total / 2) {
            
            if nums.reduce(0, +) - (total / 2) == total / 2 {
                return true
            }
            return false
            
        }
        
        let n = nums.count
        let s = total / 2
        
        var sums = [[Int]](repeating: [Int](repeating: 0, count: s + 1), count: n + 1)
        
        for i in 1...n {
            for j in 1...s {
                if nums[i - 1] > j {
                    sums[i][j] = sums[i - 1][j];
                } else {
                    sums[i][j] = max(sums[i - 1][j], sums[i - 1][j - nums[i - 1]] + nums[i - 1])
                }
            }
        }
        
        if sums[n][s] == s {
            return true
        }
        
        return false
    }

}
