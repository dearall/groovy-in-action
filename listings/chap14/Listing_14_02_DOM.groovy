//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
import javax.xml.parsers.DocumentBuilderFactory
import static org.w3c.dom.Node.*

def factory = DocumentBuilderFactory.newInstance()
def builder = factory.newDocumentBuilder()
def doc     = builder.parse(new FileInputStream('data/plan.xml'))
def plan    = doc.documentElement

String info(node) {
  switch (node.nodeType) {
    case ELEMENT_NODE:
      return "element: $node.nodeName"
    case ATTRIBUTE_NODE:
      return "attribute: $node.nodeName=$node.nodeValue"
    case TEXT_NODE:
      return "text: $node.nodeValue"
  }
  return "some other type: $node.nodeType"
}

assert info(plan) == 'element: plan'
println "info(plan): " + info(plan)
assert plan.childNodes.length == 5                              //#1
println "plan.childNodes.length: " + plan.childNodes.length

// what we'd have to do without groovy-xml DGM methods
//def firstWeek = null
//for (int i = 0; !firstWeek && i < plan.childNodes.length; i++) {
//  if (plan.childNodes.item(i).nodeName == 'week')
//    firstWeek = plan.childNodes.item(i)
//}

def firstWeek = plan.childNodes.find { it.nodeName == 'week' }  //#2
assert info(firstWeek) == 'element: week'
println "info(firstWeek): " + info(firstWeek)

def firstWeekCapacity = firstWeek.attributes.getNamedItem('capacity')
assert info(firstWeekCapacity) == 'attribute: capacity=8'
println "info(firstWeekCapacity): " + info(firstWeekCapacity)

def firstTask = firstWeek.childNodes.item(1)                    //#3
assert info(firstTask) == 'element: task'
println "info(firstTask): " + info(firstTask)

def firstTaskText = firstTask.childNodes.item(0)
assert info(firstTaskText) == 'text: easy'
println "info(firstTaskText): " + info(firstTaskText)

def firstTaskTitle = firstTask.attributes.getNamedItem('title')
assert info(firstTaskTitle) == 'attribute: title=read XML chapter'
println "info(firstTaskTitle): " + info(firstTaskTitle)

def firstTaskTitleText = firstTaskTitle.childNodes.item(0)
assert info(firstTaskTitleText) == 'text: read XML chapter'
println "info(firstTaskTitleText): " + info(firstTaskTitleText)
//#1 Element and whitespace children visible
//#2 Object iteration method
//#3 Indexed access
