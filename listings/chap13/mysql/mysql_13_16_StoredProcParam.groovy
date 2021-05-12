import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

sql.execute '''DROP PROCEDURE IF EXISTS FULL_NAME;'''

sql.execute '''
  CREATE PROCEDURE FULL_NAME (p_lastname VARCHAR(64))
  READS SQL DATA
  BEGIN
    DECLARE ans VARCHAR(100);
    SELECT CONCAT(firstname, ' ', lastname) INTO ans
    FROM Athlete WHERE lastname = p_lastname;
    SELECT ans;
  END
'''

println sql.firstRow("call FULL_NAME(?)", ['Tergat'])[0]

assert sql.firstRow("call FULL_NAME(?)", ['Tergat'])[0] == 'Paul Tergat'
