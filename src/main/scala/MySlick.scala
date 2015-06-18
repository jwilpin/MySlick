import java.sql.{Timestamp, Date}
import java.text.SimpleDateFormat

import persistence.postgresql.Tables.{EmpresasRow, PersonasRow, Empresas, Personas}
import scala.slick.driver.PostgresDriver.simple._
//import persistence.mysql.Tables.{Empresas, Personas}
//import scala.slick.driver.MySQLDriver.simple._

// The main application
object MySlick extends App {

  // The query interface for the Suppliers table
  val personas: TableQuery[Personas] = TableQuery[Personas]

  // the query interface for the Coffees table
  val empresas: TableQuery[Empresas] = TableQuery[Empresas]

  // Create a connection (called a "session") to an in-memory H2 database
  //lazy val DB = Database.forURL(driver = "com.mysql.jdbc.Driver", user = "root", password = "00155744", url = "jdbc:mysql://localhost:3306/mydb")
  lazy val DB = Database.forURL(driver = "org.postgresql.Driver", user = "postgres", password = "00155744", url = "jdbc:postgresql://localhost/mydb")
  DB.withSession { implicit session =>

    // Crea    te the schema by combining the DDLs for the Suppliers and Coffees tables using the query interfaces
    //(personas.ddl ++ empresas.ddl).create

    //personas += PersonasRow(1, Some("CC"), "1", Some("FULANITO"), "DE TAL", Some("M"), new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1982-10-15").getTime), 3000000)
    //personas += PersonasRow(2, Some("CC"), "2", Some("MARIA"), "DEL PILAR", Some("F"), new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1995-12-24").getTime), 600000)
    //personas += PersonasRow(3, Some("CE"), "1", Some("JUAN"), "OSPINA", Some("M"), new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2010-10-10").getTime), 1000000)
    //personas += PersonasRow(4, Some("CC"), "3", Some("FERNANDO"), "BURITICA", Some("M"), new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1980-01-01").getTime), 2500000)

    /*empresas ++= Set (
     EmpresasRow(0, "CE", "800123456", "MI EMPRESITA 1", "P", new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2015-01-01").getTime), new Timestamp(System.currentTimeMillis()), 4),
     EmpresasRow(0, "CE", "123456", "EMPRESOTA", "P", new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1982-10-15").getTime), new Timestamp(System.currentTimeMillis()), 4))
    */

    println("Filtering...")
    personas.filter(_.salario === 6000000d).foreach {println}

    println("Updating...")
    personas.filter(_.sexo === "F").map(_.salario).update(0d)
    println("Updated...")
    personas.foreach {println}
    personas.filter(_.sexo =!= "M").map(_.salario).update(1000000d)
    println("Updated...")
    personas.foreach {println}

    println("Projection...")
    personas.map(p => (p.nombres.get, p.apellidos))foreach {println}

    println("Cartesian Product...")
    personas.flatMap(p => empresas.map(emp => (p.nombres.get, p.apellidos, emp.razonSocial)))foreach {println}

    println("Inner Join...")
    personas flatMap (
      p => empresas filter (e => p.cdpersona === e.idAdministrador) map (
        e => (p.nombres.get, p.apellidos, e.razonSocial)
      )
    )foreach {println}

    println("Implicit Inner Join...")
    for {
      e <- empresas
      p <- personas
    } yield (p.nombres.get, p.apellidos, e.razonSocial)

    println("Explicit Join...")
    val empToPer = (e: Empresas, p: Personas) => e.idAdministrador === p.cdpersona
    empresas join personas on empToPer foreach println


  }
}
