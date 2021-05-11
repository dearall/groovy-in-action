@Grapes([
        @Grab(group='mysql', module='mysql-connector-java', version='8.0.24'),
        @Grab(group='com.mchange', module='c3p0', version='0.9.5.5')
])

@GrabConfig(systemClassLoader=true)
//////////////////////////////////

import groovy.sql.Sql
import com.mchange.v2.c3p0.*;

ComboPooledDataSource dataSource = new ComboPooledDataSource();
dataSource.setDriverClass( 'com.mysql.cj.jdbc.Driver' ); //loads the jdbc driver
dataSource.setJdbcUrl( 'jdbc:mysql://localhost:3306/dbgroovy?useSSL=false' );
dataSource.setUser("devalone");
dataSource.setPassword("174314yym");
dataSource.setMaxStatements( 180 );
dataSource.setAutoCommitOnClose(true);

def sql = new Sql(dataSource)

// use 'sql' instance ...
sql.execute '''
    DROP TABLE IF EXISTS `Athlete`;
'''
sql.execute '''
  CREATE TABLE `Athlete` (
    `athleteId`   int NOT NULL AUTO_INCREMENT,
    `firstname`   VARCHAR(64),
    `lastname`    VARCHAR(64),
    `dateOfBirth` datetime,
    PRIMARY KEY (`athleteId`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
'''

sql.close()
