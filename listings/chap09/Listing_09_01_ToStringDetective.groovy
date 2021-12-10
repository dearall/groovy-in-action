import groovy.transform.ToString

@ToString
class Detective {
  String firstName, lastName
}

def sherlock  = new Detective(firstName: 'Sherlock', lastName: 'Holmes')
assert sherlock .toString() == 'Detective(Sherlock, Holmes)'

//Added by me 2021-05-02
println 'sherlock .toString(): ' + sherlock .toString()