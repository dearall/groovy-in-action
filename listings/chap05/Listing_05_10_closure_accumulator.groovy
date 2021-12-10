def foo(n) {
    return { n += it }
}

def accumulator = foo(1)
//assert accumulator(2) == 3
//assert accumulator(1) == 4

println "accumulator(2): " + accumulator(2)
println "accumulator(1): " + accumulator(1)