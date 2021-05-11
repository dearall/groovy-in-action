def newline = "\n"

assert newline.toString() == "\n"

assert newline.dump() ==
    '''<java.lang.String@a value=
 hash=10>'''

assert newline.inspect() == /'\n'/

//Added by me 2021-05-8
println newline.toString()
println newline.dump()
println newline.inspect()
