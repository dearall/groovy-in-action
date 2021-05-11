def newline = "\n"

assert newline.toString() == "\n"

assert newline.dump() ==
'''<java.lang.String@a value=
 offset=0 count=1 hash=10>'''

//Added by me 2021-05-8
println newline.toString()
println newline.dump()
println newline.inspect()
