//
//  CheapestFlightsWithinKStops787.swift
//  leetcode_swift
//
//  Created by Adriano Gaiotto de Oliveira on 2021-08-11.
//

import Foundation

class CheapestFlightsWithinKStops787 {
    
    func findCheapestPrice(_ n: Int, _ flights: [[Int]], _ src: Int, _ dst: Int, _ K: Int) -> Int {
        
        var adj = [[Flight]](repeating: [], count: n + 1)
        
        for flight in flights {
            
            adj[flight[0]].append(Flight(to: flight[1], price: flight[2], stops: 0))
            
        }
        
        var lowPrice = -1
        
        let flightQueue = Queue<Flight>()
        
        if src <= n {
            for fligth in adj[src] {
                if fligth.to == dst {
                    if K == 0 {
                        return fligth.price
                    }
                    lowPrice = fligth.price
                }
                flightQueue.enqueue(item: Flight(to: fligth.to, price: fligth.price, stops: 0))
            }
        } else {
            return  -1
        }
        
        while flightQueue.count != 0 {
            let flightFrom = flightQueue.dequeue()!
            if src <= n {
                for flight in adj[flightFrom.to] {
                    let newPrice = flightFrom.price + flight.price
                    let newStops = flightFrom.stops + 1
                    if flight.to == dst {
                        if newStops <= K {
                            if lowPrice == -1 || newPrice < lowPrice {
                                lowPrice = newPrice
                            }
                        }
                    } else {
                        if newStops < K {
                            if lowPrice == -1 || newPrice <= lowPrice {
                                flightQueue.enqueue(item: Flight(to: flight.to, price: newPrice, stops: newStops))
                            }
                        }
                    }
                }
            }
        }
        
        return lowPrice
        
    }
}

    public struct Flight {
        let to: Int
        let price: Int
        let stops: Int
    }

    extension Flight: Comparable {
      public static func <(lhs: Flight, rhs: Flight) -> Bool {
        return lhs.price < rhs.price
      }
    }

    extension Flight: Hashable {}

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
//
//
//}
