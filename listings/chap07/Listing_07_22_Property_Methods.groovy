class ClassWithProperties {
    def       someProperty
    public    someField
    private   somePrivateField
}

def obj = new ClassWithProperties()

def store = []
obj.properties.each { property ->
    store += property.key
    store += property.value
}
assert store.contains('someProperty')
assert store.contains('someField')        == false 
assert store.contains('somePrivateField') == false
assert store.contains('class')

println "store: " + store
println "store.size(): " + store.size()

assert obj.properties.size() == 2

println "obj.properties[0]: " + obj.properties[0]
println "obj.properties[1]: " + obj.properties[1]

obj.someField = 1
obj.somePrivateField = "somePrivateField"

store.clear()

obj.properties.each { property ->
    store += property.key
    store += property.value
}

println "store: " + store
println "store.size(): " + store.size()