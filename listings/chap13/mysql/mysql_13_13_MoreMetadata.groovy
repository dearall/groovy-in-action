import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

def dump2(sql, tablename) {
  def printColNames = { meta ->
    def width = meta.columnCount * 12
    println " CONTENT OF TABLE ${tablename} ".center(width, '-')
    (1..meta.columnCount).each {
      print meta.getColumnLabel(it).padRight(12)
    }
    println()
    println '-' * width
  }
  def printRow = { row ->
    row.toRowResult().values().each {
      print it.toString().padRight(12)
    }
    println()
  }
  sql.eachRow('SELECT * FROM ' + tablename, printColNames, printRow)
}

//--------------For 'Athlete' table --------------------------------------------------------
def oldOut = System.out
def baos = new ByteArrayOutputStream()
System.setOut(new PrintStream(baos))

dump2(sql, 'Athlete')

/*
assert baos.toString().readLines()*.trim().join('\n') == '''\
----------- CONTENT OF TABLE Athlete -----------
athleteId   firstname   lastname    dateOfBirth
------------------------------------------------
1           Paul        Tergat      1969-06-17T00:00
2           Khalid      Khannouchi  1971-12-22T00:00
3           Ronaldo     da Costa    1970-06-07T00:00\
'''
*/

System.setOut(oldOut)
println baos.toString().readLines()*.trim().join('\n')

//--------------For 'Record' table --------------------------------------------------------
baos.reset()
System.setOut(new PrintStream(baos))


dump2(sql, 'Record')
System.setOut(oldOut)
println baos.toString().readLines()*.trim().join('\n')

assert baos.toString().readLines()*.trim().join('\n') == '''\
----------------- CONTENT OF TABLE Record ------------------
recordId    time        venue       whenRun     fkAthlete
------------------------------------------------------------
1           7495        Berlin      2003-09-28  1
2           7538        London      2002-04-14  2
3           7542        Chicago     1999-10-24  2
4           7565        Berlin      1998-09-20  3\
'''
