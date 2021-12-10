//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
import groovy.xml.XmlParser
def plan = new XmlParser().parse(new File('data/plan.xml'))    // #1

assert plan.name() == 'plan'
println "plan.name(): " + plan.name()

assert plan.week[0].name() == 'week'
println "plan.week[0].name(): " + plan.week[0].name()

def firstTask = plan.week[0].task[0]                           // #2
assert firstTask.name() == 'task'
assert firstTask.text() == 'easy'
println "firstTask.text(): " + firstTask.text()

assert firstTask.@title == 'read XML chapter'
println "firstTask.@title: " + firstTask.@title

// bonus examples below here for comparison with other listings
assert plan.children().size() == 2
println "plan.children().size(): " + plan.children().size()

//def firstWeek = plan.children().find { it.name() == 'week' }
//def firstWeek = plan.week[0]
assert firstTask.'@title' == 'read XML chapter'
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

assert plan.'**'*.name().join('->') ==
    'plan->week->task->task->task->week->task->task'
println "plan.'**'*.name().join('->'): " + plan.'**'*.name().join('->')
