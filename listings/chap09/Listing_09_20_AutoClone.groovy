import groovy.transform.AutoClone

@AutoClone
class Chef1 {
    String name
    List<String> recipes
    Date born
}

def name = 'Heston Blumenthal'
def recipes = ['Snail porridge', 'Bacon & egg ice cream']
def born = Date.parse('yyyy-MM-dd', '1966-05-27')
def c1 = new Chef1(name: name, recipes: recipes, born: born)
def c2 = c1.clone()
assert c2.recipes == recipes

//Added by me 2021-05-06
println 'c1.recipes: ' + c1.recipes
println 'c2.recipes: ' + c2.recipes