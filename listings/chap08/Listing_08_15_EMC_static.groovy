Integer.metaClass.static.answer = {-> 42}

assert Integer.answer() == 42
println 'Integer.answer(): ' + Integer.answer()