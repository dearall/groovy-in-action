def log = ''
(1..10).each { counter -> log += counter }
assert log == '12345678910'

//added by me 2021-05-01
println log

log = ''
(1..10).each { log += it }
assert log == '12345678910'

//added by me 2021-05-01
println log