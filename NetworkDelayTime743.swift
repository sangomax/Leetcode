//
//  NetworkDelayTime743.swift
//  leetcode_swift
//
//  Created by Adriano Gaiotto de Oliveira on 2021-08-11.
//

import Foundation

class NetworkDelayTime743 {
    
    func networkDelayTime(_ times: [[Int]], _ n: Int, _ k: Int) -> Int {
        
        
        func dijkstra(_ adj: inout [[Times]],_ n: Int,_ src: Int) -> [Int] {
            
            var dist = [Int](repeating: 101, count: n + 1)
            var check = [Bool](repeating: false, count: n + 1)
            
            dist[src] = 0
            check[src] = true
            
            for _ in 1...n {
                // get the min dist vertex
                var min = 101
                var minVertex = src
                for v in 1...n {
                    if !check[v] && dist[v] < min {
                        min = dist[v]
                        minVertex = v
                    }
                }
                // relax all neighbor edges
                check[minVertex] = true
                for edge in adj[minVertex] {
                    let to = edge.to
                    if dist[to] > dist[minVertex] + edge.weight {
                        dist[to] = dist[minVertex] + edge.weight
                    }
                }
            }
            
            dist[0] = 0
            
            return dist.contains(101) ? [-1] : dist
        }
        
        var adj = [[Times]](repeating: [], count: n + 1)
        
        for time in times {
            
            adj[time[0]].append(Times(to: time[1], weight: time[2]))
            
        }
        
        let timesL = dijkstra(&adj, n, k)
        
        return timesL.max()!
    }
}





public struct Times {
    let to: Int
    let weight: Int
}

extension Times: Comparable {
    public static func <(lhs: Times, rhs: Times) -> Bool {
        return lhs.weight < rhs.weight
    }
}

extension Times: Hashable {}


//    public final class Queue<E> : Sequence {
//
//        /// beginning of queue
//        private var first: Node<E>? = nil
//
//        /// number of items on queue
//        private(set) var count: Int = 0
//
//        /// Initializes an empty queue.
//        public init() {}
//
//        /// add an item
//        /// - Parameter item: the item to add to this queue
//        public func enqueue(item: E) {
//            if first != nil {
//            var current = first
//                while current?.next != nil {current = current?.next}
//            current?.next = Node<E>(item: item)
//            } else {
//                first = Node<E>(item: item)
//            }
//            count += 1
//        }
//
//        /// removes and returns the item least recently added to the queue
//        /// - Returns: the item removed of this queue
//        public func dequeue() -> E? {
//            if first != nil {
//                let temp = first
//                first = first?.next
//                count -= 1
//                return temp?.item
//            }
//            return nil
//        }
//
//        /// returns the item least recently added to the queue
//        /// - Returns: the item least recently added to this queue
//        public func peek() -> E? {
//            if first != nil {
//                return first?.item
//            }
//            return nil
//        }
//
//
//        /// verify if this queue is empty?
//        /// - Returns: true or false
//        public func isEmpty() -> Bool {
//            return first == nil
//        }
//
//        public func makeIterator() -> QueueIterator<E> {
//            return QueueIterator<E>(first)
//        }
//
//    }
//
//    extension Queue {
//        /// helper linked list node class
//        fileprivate class Node<E> {
//          fileprivate var item: E
//          fileprivate var next: Node<E>?
//          fileprivate init(item: E, next: Node<E>? = nil) {
//            self.item = item
//            self.next = next
//          }
//        }
//    }
//
//
//    extension Queue {
//        public struct QueueIterator<E> : IteratorProtocol {
//            public typealias Element = E
//
//            private var current: Node<E>?
//
//            fileprivate init(_ first: Node<E>?) {
//              self.current = first
//            }
//
//            public mutating func next() -> E? {
//              if let item = current?.item {
//                current = current?.next
//                return item
//              }
//              return nil
//            }
//        }
//
//    }


public struct IndexPriorityQueue<Key: Comparable & Hashable> {
    /// the array that stores the heap's nodes
    private(set) var elements = [Key]()
    /// determines whether this is a max-heap(>) or min-heap(<)
    private var order: (Key, Key) -> Bool
    /// dictionary from elements to its heap position(index) in the `elements` array
    private var indices = [Key: Int]()
    
    /// Returns true if this priority queue is empty
    public var isEmpty: Bool {
        return elements.isEmpty
    }
    
    /// Returns the number of keys on this priority queue.
    public var count: Int {
        return elements.count
    }
    
    /// Returns the min or max key O(1)
    public var peek: Key? {
        return elements.first
    }
    
    /// Initializes an empty indexed priority queue with indices
    /// - Parameter order: order of priority queue (`min <` or `max >`)
    public init(_ order: @escaping (Key, Key) -> Bool) {
        self.order = order
    }
    
    /// Returns the index of the given key element. (amortized constant time **O(1)**)
    /// - Parameter key: key element
    /// - Returns: the index of the given key element
    public func index(of key: Key) -> Int? {
        return indices[key]
    }
    
    /// Is `key` on this priority queue? **O(1)**
    /// - Parameter key: key element
    /// - Returns: `true` if key exists on this priority queue; `false` otherwise.
    public func contains(key: Key) -> Bool {
        return indices[key] != nil
    }
    
    /// Enqueue key element on this priority queue. **O (log N)**
    /// - Parameter key: key element
    public mutating func enqueue(_ key: Key) {
        guard !contains(key: key) else { return }
        elements.append(key)
        indices[key] = elements.count - 1
        siftUp(from: elements.count - 1)
    }
    
    /// Dequeue the root node on this priority queue. **O(log N)**
    /// - Returns: the root node if the priority queue is not empty
    @discardableResult
    public mutating func dequeue() -> Key? {
        if isEmpty { return nil }
        let peek = self.peek!
        swapAt(0, count - 1)
        elements.remove(at: count - 1)
        indices[peek] = nil
        siftDown(from: 0)
        return peek
    }
    
    /// Update the old key to the new key value. **O(log N)**
    /// - Parameters:
    ///   - oldKey: old key
    ///   - newKey: new key
    public mutating func update(oldKey: Key, to newKey: Key) {
        guard let index = indices[oldKey] else { return }
        elements[index] = newKey
        siftDown(from: index)
        siftUp(from: index)
    }
    
    /// Delete the key at index `i` in this priority queue. **O(log N)**
    /// - Parameter i: index of the key to delete
    public mutating func delete(at i: Int) {
        swapAt(i, count - 1)
        elements.remove(at: count - 1)
        indices[elements[i]] = nil
        siftUp(from: i)
        siftDown(from: i)
    }
    
    /**
     Private helper methods
     */
    private mutating func siftUp(from i: Int) {
        var i = i
        while i > 0 && order(elements[parent(of: i)], elements[i]) {
            swapAt(parent(of: i), i)
            i = parent(of: i)
        }
    }
    
    private mutating func siftDown(from i: Int) {
        var i = i
        while left(of: i) < count {
            var j = left(of: i)
            if j < count - 1 && order(elements[j], elements[j + 1]) {
                j += 1
            }
            if !order(elements[i], elements[j]) { break }
            swapAt(i, j)
            i = j
        }
    }
    
    private mutating func swapAt(_ i: Int, _ j: Int) {
        elements.swapAt(i, j)
        indices[elements[i]] = i
        indices[elements[j]] = j
    }
    
    @inline(__always) private func parent(of index: Int) -> Int {
        return (index - 1) / 2
    }
    
    @inline(__always) private func left(of index: Int) -> Int {
        return 2 * index + 1
    }
    
    @inline(__always) private func right(of index: Int) -> Int {
        return 2 * index + 2
    }
}


