def myMap = [a:1, b:2, c:3]
myMap.clear()
assert myMap.isEmpty()
println "myMap.isEmpty(): " + myMap.isEmpty()

myMap = [a:1, b:2, c:3]
myMap.remove('a')
assert myMap.size() == 2
println "myMap: " + myMap

assert [a:1] + [b:2] == [a:1, b:2]
println "[a:1] + [b:2]: " + ([a:1] + [b:2])

myMap = [a:1, b:2, c:3]
def abMap = myMap.subMap(['a', 'b'])                     //#1
assert abMap.size() == 2
println "myMap.subMap(['a', 'b']): " + (myMap.subMap(['a', 'b']))

abMap = myMap.findAll   { entry -> entry.value < 3 }
assert abMap.size() == 2
assert abMap.a      == 1

def found = myMap.find  { entry -> entry.value < 2 }
assert found.key   == 'a'
assert found.value == 1

def doubled = myMap.collect { entry -> entry.value *= 2 }
assert doubled instanceof List
assert doubled.every    { item -> item % 2 == 0 }

def addTo = []
myMap.collect(addTo)    { entry -> entry.value *= 2 }
assert addTo instanceof List
assert addTo.every      { item -> item % 2 == 0 }
println "addTo: " + addTo
//#1 Create a view onto the original map
