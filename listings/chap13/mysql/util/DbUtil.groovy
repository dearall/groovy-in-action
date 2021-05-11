package util

@Grapes([
        @Grab(group = 'mysql', module = 'mysql-connector-java', version = '8.0.24'),
        @Grab(group = 'com.mchange', module = 'c3p0', version = '0.9.5.5')
])

@GrabConfig(systemClassLoader = true)

import groovy.sql.Sql
import com.mchange.v2.c3p0.*
import groovy.transform.CompileStatic

import javax.sql.DataSource;
import java.util.logging.Level
import java.util.logging.Logger
import groovy.transform.*

@CompileStatic
class DbUtil {
    static Sql getSql(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass('com.mysql.cj.jdbc.Driver'); //loads the jdbc driver
//        dataSource.setJdbcUrl('jdbc:mysql://localhost:3306/dbgroovy?useSSL=false');
//        dataSource.setUser("devalone");
//        dataSource.setPassword("174314yym");

        new Sql(dataSource as DataSource)
    }
    static Sql create() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        def sql = new Sql(dataSource as DataSource)

        sql.execute """
            DROP TABLE IF EXISTS `Record`;
        """
        sql.execute """
            DROP TABLE IF EXISTS `Athlete` cascade ;
        """

        sql.execute """
            CREATE TABLE `Athlete` (
              `athleteId`   int NOT NULL AUTO_INCREMENT,
              `firstname`   VARCHAR(64),
              `lastname`    VARCHAR(64),
              `dateOfBirth` datetime,
              PRIMARY KEY (`athleteId`)
          ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
        """

        sql.execute '''
            CREATE TABLE Record (
              recordId    INTEGER NOT NULL AUTO_INCREMENT,
              time        INTEGER,    -- in seconds
              venue       VARCHAR(64),
              whenRun     DATE,
              fkAthlete   INTEGER,
              PRIMARY KEY (`recordId`),
              KEY `fk` (`fkAthlete`),
              CONSTRAINT `fk` FOREIGN KEY (`fkAthlete`) REFERENCES `athlete` (`athleteId`) ON DELETE CASCADE
            )ENGINE=InnoDB DEFAULT CHARSET=utf8;
        '''
        sql
    }

    static void populate(sql) {
        insertAthlete(sql, 'Paul', 'Tergat', '1969-06-17')
        insertAthlete(sql, 'Khalid', 'Khannouchi', '1971-12-22')
        insertAthlete(sql, 'Ronaldo', 'da Costa', '1970-06-07')
        insertRecord(sql, 2, 4, 55, 'Berlin', '2003-09-28', 'Tergat')
        insertRecord(sql, 2, 5, 38, 'London', '2002-04-14', 'Khannouchi')
        insertRecord(sql, 2, 5, 42, 'Chicago', '1999-10-24', 'Khannouchi')
        insertRecord(sql, 2, 6, 05, 'Berlin', '1998-09-20', 'da Costa')
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    static void insertAthlete(sql, first, last, dob) {
        sql.execute """
            INSERT INTO Athlete (firstname, lastname, dateOfBirth)
            VALUES (${first},${last},${dob})
        """
    }
    @CompileStatic(TypeCheckingMode.SKIP)
    static void insertRecord(sql, h, m, s, venue, date, lastname) {
        def time = h * 60 * 60 + m * 60 + s
        sql.execute """
            INSERT INTO Record (time, venue, whenRun, fkAthlete)
              SELECT $time, $venue, $date,
                athleteId FROM Athlete WHERE lastname=$lastname
        """
    }

    // To enable logging, call the method below. You might also need
    // to adjust the logging.properties file in JRE_HOME/lib to have:
    // java.util.logging.ConsoleHandler.level = FINE
    static void enableLogging() {
        Logger.getLogger('groovy.sql').level = Level.FINE
    }
}
