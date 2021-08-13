//
//  LongestCommonSubsequence1143.swift
//  leetcode_swift
//
//  Created by Adriano Gaiotto de Oliveira on 2021-08-11.
//

import Foundation

class LongestCommonSubsequence1143 {
    
    func longestCommonSubsequence(_ text1: String, _ text2: String) -> Int {
        var n = text1.count
        var m = text2.count
        var dp  = [[Int]](repeating: [Int](repeating: 0, count: m + 1), count: n + 1)
        
        let word1 = Array(text1)
        let word2 = Array(text2)
        
        for i in 1...n {
            for j in 1...m {
                if word1[i - 1] == word2[j - 1] {
                    dp[i][j] = 1 + dp[i-1][j-1]
                } else {
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
                }
            }
        }
        return dp[n][m]
    }
}



//    extension String {
//        subscript(index: Int) -> String {
//            get {
//                return String(self[self.index(startIndex, offsetBy: index)])
//            }
//            set {
//                let startIndex = self.index(self.startIndex, offsetBy: index)
//                self = self.replacingCharacters(in: startIndex..<self.index(after: startIndex), with: newValue)
//            }
//        }
//
//        subscript(start: Int, end: Int) -> String {
//            get {
//                let startIndex = self.index(self.startIndex, offsetBy: start)
//                let endIndex = self.index(self.startIndex, offsetBy: end)
//                return String(self[startIndex..<endIndex])
//            }
//            set {
//                let startIndex = self.index(self.startIndex, offsetBy: start)
//                let endIndex = self.index(self.startIndex, offsetBy: end)
//                self = self.replacingCharacters(in: startIndex..<endIndex, with: newValue)
//            }
//        }
//    }


