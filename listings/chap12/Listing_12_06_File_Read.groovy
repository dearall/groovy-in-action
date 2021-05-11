example = new File('data/example.txt')

lines = ['line one', 'line two', 'line three']
assert lines == example.readLines()

//Added by me 2021-05-9
println()
println example.readLines()

example.eachLine {
  assert it.startsWith('line')
}

hex = []
example.eachByte { hex << it }
assert hex.size() == example.length()
//Added by me 2021-05-9
println()

def splitted = example.splitEachLine(/\s/) {
  assert 'line' == it[0]

  //Added by me 2021-05-9
  println it
}


example.withReader { reader ->
  assert 'line one' == reader.readLine()
}
