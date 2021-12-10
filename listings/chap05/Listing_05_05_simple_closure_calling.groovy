Closure adder = { x, y -> return x+y }

assert adder(4, 3) == 7
assert adder.call(2, 6) == 8

println "adder(4, 3): " + adder(4, 3)
println "adder.call(2, 6): " + adder.call(2, 6)
