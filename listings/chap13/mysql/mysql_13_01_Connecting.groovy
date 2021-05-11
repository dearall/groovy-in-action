@Grapes(
        @Grab(group='mysql', module='mysql-connector-java', version='8.0.24')
)
@GrabConfig(systemClassLoader=true)
//////////////////////////////////


import groovy.sql.Sql

def url = 'jdbc:mysql://localhost:3306/dbgroovy?useSSL=false'
def user = 'devalone'
def password = '174314yym'
def driver = 'com.mysql.cj.jdbc.Driver'
def sql = Sql.newInstance(url, user, password, driver)

// use 'sql' instance ...


sql.close()
