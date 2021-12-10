def oracle(Object o) { return 'object' }
def oracle(String o) { return 'string' }

Object x = 1
Object y = 'foo'

assert 'object' == oracle(x)
println "oracle(x): " + oracle(x)

assert 'string' == oracle(y)                           //#A
println "oracle(y): " + oracle(y)
//#A This would return object in Java
