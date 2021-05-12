import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

sql.execute '''
  DROP PROCEDURE IF EXISTS SELECT_ATHLETE_RECORD;
'''
sql.execute '''
  CREATE PROCEDURE SELECT_ATHLETE_RECORD ()
  READS SQL DATA
  
  BEGIN
    SELECT Athlete.lastname AS lastname, Record.venue AS venue, Record.whenRun AS whenRun
    FROM Athlete, Record
    WHERE Athlete.athleteId = Record.fkAthlete
    ORDER BY whenRun;
  END
'''
def result = []
sql.eachRow('CALL SELECT_ATHLETE_RECORD()') {
  result << "$it.lastname $it.venue $it.whenRun"
}
assert result == [
    'da Costa Berlin 1998-09-20',
    'Khannouchi Chicago 1999-10-24',
    'Khannouchi London 2002-04-14',
    'Tergat Berlin 2003-09-28'
]
