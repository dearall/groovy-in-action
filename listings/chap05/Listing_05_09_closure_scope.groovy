class Mother {
  def prop = 'prop'
  def method(){ 'method' }
  Closure birth (param) {                              //#1
    def local = 'local'
    def closure = { 
      [ this, prop, method(), local, param, owner, delegate, thisObject ]
    }
    return closure
  }
}

Mother julia = new Mother()
def closure  = julia.birth('param')                    //#2

def context  = closure.call()                          //#3

assert context[0]    == julia                          //#4
assert context[1, 2] == ['prop',  'method']            //#5
assert context[3, 4] == ['local', 'param' ]            //#6

assert closure.thisObject == julia                     //|#7
assert closure.owner      == julia                     //|#7

assert closure.delegate   == julia                     //|#8
assert closure.resolveStrategy == Closure.OWNER_FIRST  //|#8


//#1 Creation method
//#2 Closure declaration time
//#3 Closure execution time
//#4 What "this" refers to
//#5 Free variables, resolved
//#6 Bound variables
//#7 Read only
//#8 Scope control

//added by me 2021-05-02
println "Mother instance: " + julia
println "closure.this: " + context[0]
println "closure.owner: " + closure.owner.toString()
println "closure.delegate: " + closure.delegate.toString()
println "closure.thisObject: " + closure.thisObject.toString()

println()

println context[1, 2]
println context[3, 4]
