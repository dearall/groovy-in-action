def myList = ['a','b','c','d','e','f']

assert myList[0..2]  == ['a','b','c']                  //#A
println 'myList[0..2]: ' + myList[0..2]

assert myList[0,2,4] == ['a','c','e']                  //#B
println 'myList[0,2,4]: ' + myList[0,2,4]

myList[0..2] = ['x','y','z']                           //#C
assert myList == ['x','y','z','d','e','f']
println 'myList: ' + myList

myList[3..5] = []                                      //#1
assert myList == ['x','y','z']
println 'myList: ' + myList

myList[1..1] = [0, 1, 2]                               //#2
assert myList == ['x', 0, 1, 2, 'z']
println 'myList: ' + myList
//#A getAt(Range)
//#B getAt(collection of indexes)
//#C putAt(Range)
//#1 Removing elements
//#2 Adding elements
