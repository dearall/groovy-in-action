myList = ['a', 'b', 'c']

assert myList.isCase('a')
println "myList.isCase('a'): " + myList.isCase('a')

assert 'b' in myList
println "'b' in myList: " + ('b' in myList)

def candidate = 'c'
switch(candidate){
    case myList : assert true; println "case myList:"; break                   //#1
    default     : assert false
}

assert ['x','a','z'].grep(myList) == ['a']             //#2
println "['x','a','z'].grep(myList): " + ['x','a','z'].grep(myList)

myList = []
if (myList) assert false                               //#3
else
    println "if([]) == false"
// Lists can be iterated with a 'for' loop
def expr = ''
for (i in [1,'*',5]){                                  //#4
    expr += i
}
assert expr == '1*5'
println "expr: " + expr
//#1 Classify by containment
//#2 Intersection filter
//#3 Empty lists are false
//#4 for in Collection
