//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
//@Grab('org.codehaus.groovy:groovy-json:2.2.0')
import groovy.json.JsonSlurper

class Jira {
  def base = 'https://issues.apache.org/jira/rest/api/latest/issue/'
  def slurper = new JsonSlurper()

  def query(key) {
    def httpConnection = new URL(base + key).openConnection()
    assert httpConnection.responseCode == httpConnection.HTTP_OK
    slurper.parse(httpConnection.inputStream.newReader())
  }
}

def jira = new Jira()
def response = jira.query("GROOVY-5999")
//println "response: " + response

response.fields.with {
  assert summary == "Make @Delegate work with @DelegatesTo"
  println "summary: " + summary

  assert fixVersions.name == ['2.1.1']
  println "fixVersions.name: " + fixVersions.name

  assert resolutiondate.startsWith('2013-02-14')
  println "resolutiondate: " + resolutiondate
}
