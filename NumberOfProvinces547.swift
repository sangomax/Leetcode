//
//  NumberOfProvinces547.swift
//  AlgorithmsDataStructures
//
//  Created by Adriano Gaiotto de Oliveira on 2021-04-08.
//

import Foundation

class NumberOfProvinces547 {
    func findCircleNum(_ isConnected: [[Int]]) -> Int {
           var t = UF(isConnected.count)
        
        var connected = isConnected.count
            
        for i in 0..<isConnected.count {
            
            for j in 0..<isConnected[i].count {
                
                if i == j {
                    continue
                }
                
                if !t.connected(i, j) {
                    if isConnected[i][j] == 1 {
                        t.union(i, j)
                        connected -= 1
                    }
                }
            }
            
        }
            
            return connected
            
            
        }
    


    private struct UF {
        /// parent[i] = parent of i
        private var parent: [Int]
        /// size[i] = number of nodes in tree rooted at i
        private var size: [Int]
        /// number of components
        private(set) var count: Int
        
        /// Initializes an empty union-find data structure with **n** elements
        /// **0** through **n-1**.
        /// Initially, each elements is in its own set.
        /// - Parameter n: the number of elements
        public init(_ n: Int) {
            self.count = n
            self.size = [Int](repeating: 1, count: n)
            self.parent = [Int](repeating: 0, count: n)
            for i in 0..<n {
                self.parent[i] = i
            }
        }
        
        /// Returns the canonical element(root) of the set containing element `p`.
        /// - Parameter p: an element
        /// - Returns: the canonical element of the set containing `p`
        public mutating func find(_ p: Int) -> Int {
            var node = p
            while node != parent[node] {
                parent[p] = parent[parent[p]]
                node = parent[node]
            }
            return node
        }
        
        /// Returns `true` if the two elements are in the same set.
        /// - Parameters:
        ///   - p: one elememt
        ///   - q: the other element
        /// - Returns: `true` if `p` and `q` are in the same set; `false` otherwise
        public mutating func connected(_ p: Int, _ q: Int) -> Bool {
            return find(p) == find(q)
        }
        
        /// Merges the set containing element `p` with the set containing
        /// element `q`
        /// - Parameters:
        ///   - p: one element
        ///   - q: the other element
        public mutating func union(_ p: Int, _ q: Int) {
            var i : Int = find(p)
            var j : Int = find(q)
            if i == j { return }
            if size[i] < size[j] {
                parent[i] = j
                size[j] += size[i]
            } else {
                parent[j] = i
                size[i] += size[j]
            }
        }
    }
}
