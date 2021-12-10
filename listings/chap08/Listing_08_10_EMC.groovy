assert String.metaClass =~ /MetaClassImpl/
println 'String.metaClass =~ /MetaClassImpl/: ' + ((String.metaClass =~ /MetaClassImpl/) as Boolean)

String.metaClass.low    = {-> delegate.toLowerCase() }
assert String.metaClass =~ /ExpandoMetaClass/
println 'String.metaClass =~ /ExpandoMetaClass/: ' + ((String.metaClass =~ /ExpandoMetaClass/) as Boolean)

assert "DiErK".low() == "dierk"
println '"DiErK".low(): ' + "DiErK".low()