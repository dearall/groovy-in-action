def host = /\/\/([a-zA-Z0-9-]+(\.[a-zA-Z0-9-])*?)(:|\/)/        //#A

assertHost 'http://a.b.c:8080/bla',     host, 'a.b.c'
assertHost 'http://a.b.c/bla',          host, 'a.b.c'
assertHost 'http://127.0.0.1:8080/bla', host, '127.0.0.1'
assertHost 'http://t-online.de/bla',    host, 't-online.de'
assertHost 'http://T-online.de/bla',    host, 'T-online.de'

def assertHost (candidate, regex, expected){
    candidate.eachMatch(regex){ assert it[1] == expected }
}

// ... use host regex ...                                       //#B
//#A Regular expression matching host
//#B Trailing code goes here

'http://a.b.c/bla'.eachMatch(host){ println it }




input = new File('no-such-file.txt')
assert input.exists(), "can not find file ${input.name}"
assert input.canRead()
println input.text