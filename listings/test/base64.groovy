byte[] data = new byte[256]
for (i in 0..255) { data[i] = i }
println "data.toList(): \n" + data.toList()

store = data.encodeBase64().toString()
println "store: \n" + store

assert store.startsWith('AAECAwQFBg')
assert store.endsWith ('r7/P3+/w==')

restored = store.decodeBase64()
assert data.toList() == restored.toList()
println "restored.toList(): \n" + restored.toList()