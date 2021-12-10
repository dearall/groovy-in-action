def newline = "\n"

assert newline.toString() == "\n"
/**
 *

assert newline.dump() ==
    '''<java.lang.String@a value=
 hash=10>'''
 */
assert newline.inspect() == /'\n'/


//Added by me 2021-05-8
println "newline.toString(): " + newline.toString()
println "newline.dump(): " + newline.dump()
println "newline.inspect(): " + newline.inspect()
