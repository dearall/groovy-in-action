def greeting = 'Hello'

greeting <<= ' Groovy'                                 //#1

println greeting

assert greeting instanceof java.lang.StringBuffer

println greeting.class.name
println greeting.class.class
println greeting.class.toString()

greeting << '!'                                        //#2

assert greeting.toString() == 'Hello Groovy!'

greeting[1..4] = 'i'                                   //#A

println greeting

assert greeting.toString() == 'Hi Groovy!'
//#1 Left shift and assign
//#2 Left shift on StringBuffer
//#A Substring 'ello' becomes 'i'
