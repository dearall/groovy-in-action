def log = ''
(1..10).each { counter -> log += counter }
assert log == '12345678910'

println "log: " + log   //added by me 2021-05-01


log = ''
(1..10).each { log += it }
assert log == '12345678910'

println log //added by me 2021-05-01