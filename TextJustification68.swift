//
//  TextJustification68.swift
//  leetcode_swift
//
//  Created by Adriano Gaiotto de Oliveira on 2021-08-10.
//

import Foundation

class TextJustification68 {
    func fullJustify(_ words: [String], _ maxWidth: Int) -> [String] {
        
    var l = [String]()
    
    var line = -1
    for word in words {
        if line == -1 {
            l.append(word)
            line += 1
        } else if ("\(l[line]) \(word)").count <= maxWidth {
            l[line] += " " + word
        } else {
            l.append(word)
            line += 1
        }
    }
    
    
    for i in 0..<l.count - 1 {
        
        var words = l[i].split(separator: " ").map { String($0) }
        var numSpaces = [Int](repeating: 0, count: words.count)
        
        l[i] = l[i].replacingOccurrences(of: " ", with: "")
        var numSpace = 0
        while (l[i].count + numSpace) < maxWidth {
            if words.count > 1 {
                for w in 0..<words.count - 1 {
                    if (l[i].count + numSpace) + 1 <= maxWidth {
                        words[w] += " "
                        numSpaces[w] += 1
                        numSpace = numSpaces.reduce(0, { x, y in x + y })
                    } else {
                        break
                    }
                }
                
            } else {
                numSpace = maxWidth - words[0].count
                words[0] += String(repeating: " ", count: numSpace)
            }
        }
        
        l[i] = words.reduce("", { x, y in x + y })
    }
    
    var lastPos = l.count - 1
    l[lastPos] += String(repeating: " ", count: maxWidth - l[lastPos].count)
    
    return l
    
}



}
