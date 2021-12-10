//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
import groovy.xml.XmlSlurper
def plan = new XmlSlurper().parse(new File('data/plan.xml'))

assert plan.week.task.size() == 5
println "plan.week.task.size(): " + plan.week.task.size()

assert plan.week.task.@done*.toInteger().sum() == 6
println "plan.week.task.@done*.toInteger().sum(): " + plan.week.task.@done*.toInteger().sum()

assert plan.week[1].task.every{ it.@done == '0' }
println "plan.week[1].task.every{ it.@done == '0' }: " + plan.week[1].task.every{ it.@done == '0' }

assert plan.breadthFirst()*.name().join('->') ==
    'plan->week->week->task->task->task->task->task'
println "plan.breadthFirst()*.name().join('->'): " + plan.breadthFirst()*.name().join('->')

assert plan.depthFirst()*.name().join('->') ==
    'plan->week->task->task->task->week->task->task'
println "plan.depthFirst()*.name().join('->'): " + plan.depthFirst()*.name().join('->')

assert plan.depthFirst()*.name() == plan.'**'*.name()
println "plan.'**'*.name().join('->'): " + plan.'**'*.name().join('->')


// bonus material below here for comparison with other listings
assert plan.name() == 'plan'
assert plan.children().size() == 2

def firstWeek = plan.children().find { it.name() == 'week' }
def firstTask = firstWeek.task[0]
assert firstTask.name() == 'task'
assert firstTask.text() == 'easy'
assert firstTask.'@title' == 'read XML chapter'
