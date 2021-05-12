import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

def dump(sql, tablename) {
  println " CONTENT OF TABLE ${tablename} ".center(32, '-')
  sql.eachRow('SELECT * FROM ' + tablename) { rs ->
    def meta = rs.getMetaData()
    if (meta.columnCount <= 0) return
    for (i in 0..<meta.columnCount) {
      print "${i}: ${meta.getColumnLabel(i + 1)}".padRight(20)        //#1
      println rs[i]?.toString()                                       //#2
    }
    println '-' * 32
  }
}

def oldOut = System.out
def baos = new ByteArrayOutputStream()
System.setOut(new PrintStream(baos))                                  //#3

dump(sql, 'Athlete')
System.setOut(oldOut)

println baos.toString().readLines()*.trim().join('\n')

assert baos.toString().readLines()*.trim().join('\n') == '''\
--- CONTENT OF TABLE Athlete ---
0: athleteId        1
1: firstname        Paul
2: lastname         Tergat
3: dateOfBirth      1969-06-17
--------------------------------
0: athleteId        2
1: firstname        Khalid
2: lastname         Khannouchi
3: dateOfBirth      1971-12-22
--------------------------------
0: athleteId        3
1: firstname        Ronaldo
2: lastname         da Costa
3: dateOfBirth      1970-06-07
--------------------------------\
'''
//#1 Counts from 1
//#2 Counts from 0 and possibly null
//#3 Capture standard out
