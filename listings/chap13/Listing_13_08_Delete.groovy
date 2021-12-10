import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)                                                  //#A

assert sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num == 3   //#B
println "sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num: " + sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num

sql.execute "DELETE FROM Athlete WHERE lastname = 'Tergat'"

assert sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num == 2   //#C
println "sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num: " + sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num

//#A Populate using our helper method
//#B Check initially three rows
//#C Two rows left after delete
