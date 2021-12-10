myList = []

myList += 'a'                                          //#A
assert myList == ['a']
println 'myList: ' + myList

myList += ['b','c']                                    //#B
assert myList == ['a','b','c']
println 'myList: ' + myList

myList = []
myList <<  'a' << 'b'                                  //#C
assert myList == ['a','b']
println 'myList: ' + myList


assert myList - ['b'] == ['a']                         //#D
println "myList - ['b']: " + (myList - ['b'])

assert myList * 2 == ['a','b','a','b']                 //#E
println 'myList * 2: ' + myList * 2
//#A plus(Object)
//#B plus(Collection)
//#C leftShift is like append
//#D minus(Collection)
//#E Multiply
