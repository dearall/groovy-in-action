package layering

@Grapes([
        @Grab(group = 'mysql', module = 'mysql-connector-java', version = '8.0.24'),
        @Grab(group = 'com.mchange', module = 'c3p0', version = '0.9.5.5')
])
@GrabConfig(systemClassLoader = true)

import groovy.sql.Sql
import groovy.text.SimpleTemplateEngine as STE
import com.mchange.v2.c3p0.*

import javax.sql.DataSource
import java.util.logging.Level
import java.util.logging.Logger

class DbHelper {
  Sql db

  DbHelper() {
    db = new Sql(new ComboPooledDataSource() as DataSource)
    enableLogging()
  }

  def dropTemplate = new STE(true).createTemplate('''
      DROP TABLE IF EXISTS $name;
  ''')
  def simpleTemplate = new STE().createTemplate('''
    CREATE TABLE $name (
          ${lowname}Id    INTEGER NOT NULL AUTO_INCREMENT,
          $fields,
          PRIMARY KEY (${lowname}Id)
          );
    ''')

  def executeDdl(DataAccessObject dao) {
    def bindingdrop = [name: dao.tablename]
    def stmt = dropTemplate.make(bindingdrop).toString()
    db.execute(stmt)

    def template = simpleTemplate
    def binding = [
        name: dao.tablename,
        lowname: dao.tablename.toLowerCase(),
        fields: dao.schema.collect { key, val ->
          "    ${key.padRight(12)} $val" }.join(",\n")
    ]
    stmt = template.make(binding).toString()
    db.execute stmt
  }

  // To enable logging, call the method below. You might also need
  // to adjust the logging.properties file in JRE_HOME/lib to have:
  // java.util.logging.ConsoleHandler.level = FINE
  static void enableLogging() {
    Logger.getLogger('groovy.sql').level = Level.FINE
  }
}

