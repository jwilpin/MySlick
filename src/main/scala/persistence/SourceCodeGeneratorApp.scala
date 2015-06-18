//package domain
//
///**
// * Created by wilmar.pino on 17/06/2015.
// */
//object SourceCodeGeneratorApp extends App {
//  scala.slick.codegen.SourceCodeGenerator.main(
//    Array(
//      "scala.slick.driver.MySQLDriver",
//      "com.mysql.jdbc.Driver",
//      "jdbc:mysql://localhost:3306/mydb",
//      "src/main/scala/",
//      "persistence.mysql",
//      "root",
//      "00155744"
//    )
//  )
//}
//
package persistence

/**
 * Created by wilmar.pino on 17/06/2015.
 */
object SourceCodeGeneratorApp extends App {
  scala.slick.codegen.SourceCodeGenerator.main(
    Array(
      "scala.slick.driver.PostgresDriver",
      "org.postgresql.Driver",
      "jdbc:postgresql://localhost/mydb",
      "src/main/scala/",
      "persistence.postgresql",
      "postgres",
      "00155744"
    )
  )
}
