MetaClass mc = String.metaClass
final Object[] NO_ARGS = []
assert   1  == mc.respondsTo("toString", NO_ARGS).size()
assert   3  == mc.properties.size()
assert  76  == mc.methods.size()
assert 176  == mc.metaMethods.size()
assert ""   == mc.invokeMethod("","toString", NO_ARGS)
assert null == mc.invokeStaticMethod(String, "println", NO_ARGS)
assert ""   == mc.invokeConstructor(NO_ARGS)

println 'mc.respondsTo("toString", NO_ARGS).size(): ' + mc.respondsTo("toString", NO_ARGS).size()
println 'mc.properties.size(): ' + mc.properties.size()
println 'mc.methods.size(): ' + mc.methods.size()
println 'mc.metaMethods.size(): ' + mc.metaMethods.size()
println 'mc.invokeMethod("","toString", NO_ARGS): ' + mc.invokeMethod("","toString", NO_ARGS)
println 'mc.invokeStaticMethod(String, "println", NO_ARGS): ' + mc.invokeStaticMethod(String, "println", NO_ARGS)
println 'mc.invokeConstructor(NO_ARGS): ' + mc.invokeConstructor(NO_ARGS)