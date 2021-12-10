def myMap = [a:1, b:2, c:3]
def other = [b:2, c:3, a:1]

assert myMap == other                                  //#A
println "(myMap == other): " + (myMap == other)

assert !myMap.isEmpty()                                //#B
assert myMap.size()     == 3                           //#B
assert myMap.containsKey('a')                          //#B
assert myMap.containsValue(1)                          //#B
assert myMap.entrySet() instanceof Collection          //#B
println "myMap.entrySet() type: " + myMap.entrySet().class.name

assert myMap.any   {entry -> entry.value > 2  }        //#1
assert myMap.every {entry -> entry.key   < 'd'}        //#1
assert myMap.keySet() == ['a','b','c'] as Set          //#C
println "myMap.keySet(): " + myMap.keySet()
println "myMap.keySet() type: " + myMap.keySet().class.name

assert myMap.values().toList() == [1, 2, 3]            //#D
println "myMap.values() type: " + myMap.values().class.name

//#A Call to equals
//#B JDK methods
//#1 GDK methods
//#C Set equals
//#D List equals
