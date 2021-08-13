//
//  CourseSchedule207.swift
//  leetcode_swift
//
//  Created by Adriano Gaiotto de Oliveira on 2021-08-11.
//

import Foundation

class CourseSchedule207 {
    func canFinish(_ numCourses: Int, _ prerequisites: [[Int]]) -> Bool {
        
        var adj = [[Int]](repeating: [Int](), count: numCourses)
        
        var indegree = [Int](repeating: 0, count: numCourses)
        
        var checkCourse = [Bool](repeating: false, count: numCourses)
        
        for edge in prerequisites {
            let u = edge[0]
            let v = edge[1]
            adj[u].append(v) // DAG
            indegree[v] += 1
        }
        
        // Topological Sort - using BFS (Queue)
        let q = Queue<Int>()
        for v in 0..<numCourses {
            if indegree[v] == 0 {
                q.enqueue(item: v)
            }
        }
        
        // BFS O(V + E)
        while !q.isEmpty() {
            let u = q.dequeue()!
            checkCourse[u] = true
            for v in adj[u] {
                indegree[v] -= 1 // decrement indegree of all connected vertices from u
                if indegree[v] == 0 {
                    q.enqueue(item: v)
                }
            }
        }
        
        if checkCourse.contains(false) && prerequisites != [] {
            return false
        } else {
            return true
        }
        
    }
    
    
}




//public final class Queue<E> : Sequence {
//    
//    /// beginning of queue
//    private var first: Node<E>? = nil
//    
//    /// number of items on queue
//    private(set) var count: Int = 0
//    
//    /// Initializes an empty queue.
//    public init() {}
//    
//    /// add an item
//    /// - Parameter item: the item to add to this queue
//    public func enqueue(item: E) {
//        if first != nil {
//            var current = first
//            while current?.next != nil {current = current?.next}
//            current?.next = Node<E>(item: item)
//        } else {
//            first = Node<E>(item: item)
//        }
//        count += 1
//    }
//    
//    /// removes and returns the item least recently added to the queue
//    /// - Returns: the item removed of this queue
//    public func dequeue() -> E? {
//        if first != nil {
//            let temp = first
//            first = first?.next
//            count -= 1
//            return temp?.item
//        }
//        return nil
//    }
//    
//    /// returns the item least recently added to the queue
//    /// - Returns: the item least recently added to this queue
//    public func peek() -> E? {
//        if first != nil {
//            return first?.item
//        }
//        return nil
//    }
//    
//    
//    /// verify if this queue is empty?
//    /// - Returns: true or false
//    public func isEmpty() -> Bool {
//        return first == nil
//    }
//    
//    public func makeIterator() -> QueueIterator<E> {
//        return QueueIterator<E>(first)
//    }
//    
//}
//
//extension Queue {
//    /// helper linked list node class
//    fileprivate class Node<E> {
//        fileprivate var item: E
//        fileprivate var next: Node<E>?
//        fileprivate init(item: E, next: Node<E>? = nil) {
//            self.item = item
//            self.next = next
//        }
//    }
//}
//
//extension Queue {
//    public struct QueueIterator<E> : IteratorProtocol {
//        public typealias Element = E
//        
//        private var current: Node<E>?
//        
//        fileprivate init(_ first: Node<E>?) {
//            self.current = first
//        }
//        
//        public mutating func next() -> E? {
//            if let item = current?.item {
//                current = current?.next
//                return item
//            }
//            return nil
//        }
//    }
//    
//}
//
//
