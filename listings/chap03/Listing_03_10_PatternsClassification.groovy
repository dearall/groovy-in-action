def fourLetters = ~/\w{4}/

assert fourLetters.isCase('work')

println 'fourLetters.isCase(\'work\') == ' + fourLetters.isCase('work')

assert 'love' in fourLetters

println "'love' in fourLetters == " + ('love' in fourLetters)

switch('beer'){
    case fourLetters : assert true; println 'case fourLetters: true'; break
    default          : assert false
}

beasts = ['bear','wolf','tiger','regex']

assert beasts.grep(fourLetters) == ['bear','wolf']

println 'beasts.grep(fourLetters): ' + beasts.grep(fourLetters)