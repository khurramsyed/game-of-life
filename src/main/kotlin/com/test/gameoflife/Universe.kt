package com.test.gameoflife

class Universe(var size: Int) {
    var cells = Array(size) { Array(size) { Cell(false) } }
    
}