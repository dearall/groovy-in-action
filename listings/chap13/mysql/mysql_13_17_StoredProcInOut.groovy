import groovy.sql.Sql
import util.DbUtil

def sql = DbUtil.getSql()

sql.execute '''
  DROP PROCEDURE IF EXISTS CONCAT_NAME;
'''
sql.execute '''
  CREATE PROCEDURE CONCAT_NAME (OUT fullname VARCHAR(100),
    IN first VARCHAR(50), IN last VARCHAR(50))
  BEGIN
    SET fullname = CONCAT(first, ' ', last);
  END
'''

sql.call("{call CONCAT_NAME(?, ?, ?)}",
    [Sql.VARCHAR, 'Paul', 'Tergat']) {
  fullname -> assert fullname == 'Paul Tergat'
}
