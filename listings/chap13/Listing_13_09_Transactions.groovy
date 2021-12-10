import static util.DbUtil.*

def sql = create()
populate(sql)

sql.withTransaction {
    insertAthlete(sql, 'Haile', 'Gebrselassie', '1973-04-18')
    insertAthlete(sql, 'Patrick', 'Makau', '1985-03-02')
}

assert sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num == 5
println "sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num: " + sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num

sql.withTransaction { conn ->
    insertAthlete(sql, 'Haile', 'Gebrselassie2', '1973-04-18')
    insertAthlete(sql, 'Patrick', 'Makau2', '1985-03-02')
    println 'conn.class.name: ' + conn.class.name
    println 'sql: ' + sql
    println 'conn: ' + conn
}
println "sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num: " + sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num

// modify above to show transaction rollback
/*
try {
  sql.withTransaction {
    insertAthlete(sql, 'Haile', 'Gebrselassie3', '1973-04-18')
    insertAthlete(sql, 'Patrick', 'Makau3' * 100, '1985-03-02')
  }
} catch(ignore) { println ignore.message }
assert sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num == 3
println "sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num: " + sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num
*/
