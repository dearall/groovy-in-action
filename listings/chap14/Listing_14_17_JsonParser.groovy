//@Grab('org.codehaus.groovy:groovy-json:2.2.0')
import groovy.json.JsonSlurper

// add .newReader() to the file in Groovy versions prior to 2.2.0
def plan = new JsonSlurper().parse(new File('data/plan.json'))
assert plan.weeks[0].tasks[0].status == 'easy'
println "plan.weeks[0].tasks[0].status: " + plan.weeks[0].tasks[0].status

assert plan.weeks[1].capacity == 8
println "plan.weeks[1].capacity: " + plan.weeks[1].capacity

assert plan.weeks[1].tasks[0].title == 're-read DB chapter'
println "plan.weeks[1].tasks[0].title: " + plan.weeks[1].tasks[0].title
