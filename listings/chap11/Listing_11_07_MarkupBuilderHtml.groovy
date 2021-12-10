def writer = new FileWriter('markup.html')
def html   = new groovy.xml.MarkupBuilder(writer)                                   
html.html {
  head {
    title 'Constructed by MarkupBuilder'
  }
  body {
    h1 'What can I do with MarkupBuilder?'
    parent {
      mkp.yield "Some text"
      child('Child text')
      mkp.yield "more text"
    }
    form (action:'whatever') {
      for (line in ['Produce HTML','Produce XML','Have some fun']){
        input(type:'checkbox',checked:'checked', id:line, '')
        label(for:line, line)
        br()
} } } }

/**
 *
 NOTE:
 If you need to create mixed elements (that is, elements with intermingled
 text and child elements, such as <parent>Some text<child>Child
 text</child>More text</parent>) then you can use a special mkp notation.4
 Use mkp.yield normally and mkp.yieldUnescaped if you want to bypass
 escaping of special symbols like the ampersand, less-than, and greater-than
 characters, which are normally escaped and replaced with their equivalent
 HTML encoding.

 mkp is short for markup but the abbreviation isn’t likely to conflict with a name you might want to use in your
 created content.
 */