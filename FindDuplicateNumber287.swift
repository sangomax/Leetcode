//
//  FindDuplicateNumber287.swift
//  leetcode_swift
//
//  Created by Adriano Gaiotto de Oliveira on 2021-08-10.
//

import Foundation

class FindDuplicateNumber287 {
    func findDuplicate(_ nums: [Int]) -> Int {
         var d = [Int](repeating: 0, count: nums.count + 1)

    for n in nums {
        d[n] += 1
        if d[n] == 2 {
            return n
        }
    }
    
    return 0
    }
}
