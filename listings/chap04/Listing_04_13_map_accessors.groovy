def myMap = [a:1, b:2, c:3]

assert myMap['a']       == 1                           //#A
println "myMap['a']: " + myMap['a']

assert myMap.a          == 1                           //#A
println "myMap.a: " + myMap.a

assert myMap.get('a')   == 1                           //#A
println "myMap.get('a'): " + myMap.get('a')

assert myMap.get('a',0) == 1                           //#A
println "myMap.get('a',0): " + myMap.get('a',0)

assert myMap['d']       == null                        //#B
println "myMap['d']: " + myMap['d']

assert myMap.d          == null                        //#B
println "myMap.d: " + myMap.d

assert myMap.get('d')   == null                        //#B
println "myMap.get('d'): " + myMap.get('d')

println "myMap.get('d',0): " + myMap.get('d',0)
assert myMap.get('d',0) == 0                           //#C

assert myMap.d          == 0                           //#C
println "myMap.d: " + myMap.d

myMap['d'] = 1                                         //#D
assert myMap.d == 1                                    //#D
println "myMap.d: " + myMap.d

myMap.d = 2                                            //#D
assert myMap.d == 2                                    //#D
println "myMap.d: " + myMap.d

//#A Retrieve existing elements
//#B Attempt to retrieve missing elements
//#C Default value
//#D Single putAt
