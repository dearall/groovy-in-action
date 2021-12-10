def list = [1, 2, 3]

assert list.first()  == 1
println "list.first(): " + list.first()

assert list.head()   == 1
println "list.head(): " + list.head()

assert list.tail()   == [2, 3]
println "list.tail(): " + list.tail()

assert list.last()   == 3
println "list.last(): " + list.last()

assert list.count(2) == 1                              //#A
println "list.count(2): " + list.count(2)

assert list.max()    == 3                              //#A
println "list.max(): " + list.max()

assert list.min()    == 1                              //#A
println "list.min(): " + list.min()
                                                       //#A
def even = list.find { item ->                         //#A
    item % 2 == 0                                      //#A
}                                                      //#A
assert even == 2                                       //#A
println "even: " + even
//#A
assert list.every { item -> item < 5 }                 //#A
println "list.every { item -> item < 5 }: " + (list.every { item -> item < 5 })

assert list.any   { item -> item < 2 }                 //#A
println "list.any   { item -> item < 2 }: " + (list.any   { item -> item < 2 }  )

def store = ''
list.each { item ->                                    //#B
    store += item                                      //#B
}                                                      //#B
assert store == '123'                                  //#B
println "store: " + store
                                                       //#B
store = ''                                             //#B
list.reverseEach { item ->                             //#B
    store += item                                      //#B
}                                                      //#B
assert store == '321'                                  //#B
println "store: " + store
                                                       //#B
store = ''                                             //#B
list.eachWithIndex { item, index ->                    //#B
    store += "$index:$item "                           //#B
}                                                      //#B
assert store == '0:1 1:2 2:3 '                         //#B
println "store: " + store

assert list.join('-') == '1-2-3'                       //#C
println "list.join('-'): " + list.join('-')
                                                       //#C
result = list.inject(0) { clinks, guests ->            //#C
    clinks + guests                                    //#C
}                                                      //#C
assert result == 0 + 1 + 2 + 3                         //#C
assert list.sum() == 6                                 //#C
println "result: " + result
                                                       //#C
factorial = list.inject(1) { fac, item ->              //#C
    fac * item                                         //#C
}                                                      //#C
assert factorial == 1 * 1 * 2 * 3                      //#C
println "factorial: " + factorial
//#A Querying
//#B Iteration
//#C Accumulation