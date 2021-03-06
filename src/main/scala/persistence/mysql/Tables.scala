package persistence.mysql
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Empresas.ddl ++ Personas.ddl
  
  /** Entity class storing rows of table Empresas
   *  @param cdempresas Database column cdempresas DBType(INT), AutoInc, PrimaryKey
   *  @param tipoDocumento Database column tipo_documento DBType(VARCHAR), Length(2,true)
   *  @param numeroDocumento Database column numero_documento DBType(VARCHAR), Length(20,true)
   *  @param razonSocial Database column razon_social DBType(VARCHAR), Length(200,true)
   *  @param tipoEmpresa Database column tipo_empresa DBType(VARCHAR), Length(1,true)
   *  @param fechaCreacion Database column fecha_creacion DBType(DATE)
   *  @param fechaRegistro Database column fecha_registro DBType(DATETIME)
   *  @param idAdministrador Database column id_administrador DBType(INT) */
  case class EmpresasRow(cdempresas: Int, tipoDocumento: String, numeroDocumento: String, razonSocial: String, tipoEmpresa: String, fechaCreacion: java.sql.Date, fechaRegistro: java.sql.Timestamp, idAdministrador: Int)
  /** GetResult implicit for fetching EmpresasRow objects using plain SQL queries */
  implicit def GetResultEmpresasRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Date], e3: GR[java.sql.Timestamp]): GR[EmpresasRow] = GR{
    prs => import prs._
    EmpresasRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Date], <<[java.sql.Timestamp], <<[Int]))
  }
  /** Table description of table empresas. Objects of this class serve as prototypes for rows in queries. */
  class Empresas(_tableTag: Tag) extends Table[EmpresasRow](_tableTag, "empresas") {
    def * = (cdempresas, tipoDocumento, numeroDocumento, razonSocial, tipoEmpresa, fechaCreacion, fechaRegistro, idAdministrador) <> (EmpresasRow.tupled, EmpresasRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (cdempresas.?, tipoDocumento.?, numeroDocumento.?, razonSocial.?, tipoEmpresa.?, fechaCreacion.?, fechaRegistro.?, idAdministrador.?).shaped.<>({r=>import r._; _1.map(_=> EmpresasRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column cdempresas DBType(INT), AutoInc, PrimaryKey */
    val cdempresas: Column[Int] = column[Int]("cdempresas", O.AutoInc, O.PrimaryKey)
    /** Database column tipo_documento DBType(VARCHAR), Length(2,true) */
    val tipoDocumento: Column[String] = column[String]("tipo_documento", O.Length(2,varying=true))
    /** Database column numero_documento DBType(VARCHAR), Length(20,true) */
    val numeroDocumento: Column[String] = column[String]("numero_documento", O.Length(20,varying=true))
    /** Database column razon_social DBType(VARCHAR), Length(200,true) */
    val razonSocial: Column[String] = column[String]("razon_social", O.Length(200,varying=true))
    /** Database column tipo_empresa DBType(VARCHAR), Length(1,true) */
    val tipoEmpresa: Column[String] = column[String]("tipo_empresa", O.Length(1,varying=true))
    /** Database column fecha_creacion DBType(DATE) */
    val fechaCreacion: Column[java.sql.Date] = column[java.sql.Date]("fecha_creacion")
    /** Database column fecha_registro DBType(DATETIME) */
    val fechaRegistro: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("fecha_registro")
    /** Database column id_administrador DBType(INT) */
    val idAdministrador: Column[Int] = column[Int]("id_administrador")
    
    /** Foreign key referencing Personas (database name personas_cdpersona_fk) */
    lazy val personasFk = foreignKey("personas_cdpersona_fk", idAdministrador, Personas)(r => r.cdpersona, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    
    /** Index over (tipoDocumento,numeroDocumento) (database name ID_EMPRESA) */
    val index1 = index("ID_EMPRESA", (tipoDocumento, numeroDocumento))
  }
  /** Collection-like TableQuery object for table Empresas */
  lazy val Empresas = new TableQuery(tag => new Empresas(tag))
  
  /** Entity class storing rows of table Personas
   *  @param cdpersona Database column cdpersona DBType(INT), AutoInc, PrimaryKey
   *  @param tipoDocumento Database column tipo_documento DBType(VARCHAR), Length(2,true)
   *  @param numeroDocumento Database column numero_documento DBType(VARCHAR), Length(20,true)
   *  @param nombres Database column nombres DBType(VARCHAR), Length(50,true)
   *  @param apellidos Database column apellidos DBType(VARCHAR), Length(50,true)
   *  @param sexo Database column sexo DBType(VARCHAR), Length(1,true), Default(M)
   *  @param fechaNacimiento Database column fecha_nacimiento DBType(DATE)
   *  @param salario Database column salario DBType(DOUBLE) */
  case class PersonasRow(cdpersona: Int, tipoDocumento: String, numeroDocumento: String, nombres: String, apellidos: String, sexo: String = "M", fechaNacimiento: java.sql.Date, salario: Double)
  /** GetResult implicit for fetching PersonasRow objects using plain SQL queries */
  implicit def GetResultPersonasRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Date], e3: GR[Double]): GR[PersonasRow] = GR{
    prs => import prs._
    PersonasRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Date], <<[Double]))
  }
  /** Table description of table personas. Objects of this class serve as prototypes for rows in queries. */
  class Personas(_tableTag: Tag) extends Table[PersonasRow](_tableTag, "personas") {
    def * = (cdpersona, tipoDocumento, numeroDocumento, nombres, apellidos, sexo, fechaNacimiento, salario) <> (PersonasRow.tupled, PersonasRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (cdpersona.?, tipoDocumento.?, numeroDocumento.?, nombres.?, apellidos.?, sexo.?, fechaNacimiento.?, salario.?).shaped.<>({r=>import r._; _1.map(_=> PersonasRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column cdpersona DBType(INT), AutoInc, PrimaryKey */
    val cdpersona: Column[Int] = column[Int]("cdpersona", O.AutoInc, O.PrimaryKey)
    /** Database column tipo_documento DBType(VARCHAR), Length(2,true) */
    val tipoDocumento: Column[String] = column[String]("tipo_documento", O.Length(2,varying=true))
    /** Database column numero_documento DBType(VARCHAR), Length(20,true) */
    val numeroDocumento: Column[String] = column[String]("numero_documento", O.Length(20,varying=true))
    /** Database column nombres DBType(VARCHAR), Length(50,true) */
    val nombres: Column[String] = column[String]("nombres", O.Length(50,varying=true))
    /** Database column apellidos DBType(VARCHAR), Length(50,true) */
    val apellidos: Column[String] = column[String]("apellidos", O.Length(50,varying=true))
    /** Database column sexo DBType(VARCHAR), Length(1,true), Default(M) */
    val sexo: Column[String] = column[String]("sexo", O.Length(1,varying=true), O.Default("M"))
    /** Database column fecha_nacimiento DBType(DATE) */
    val fechaNacimiento: Column[java.sql.Date] = column[java.sql.Date]("fecha_nacimiento")
    /** Database column salario DBType(DOUBLE) */
    val salario: Column[Double] = column[Double]("salario")
    
    /** Index over (tipoDocumento,numeroDocumento) (database name ID_PERSONA) */
    val index1 = index("ID_PERSONA", (tipoDocumento, numeroDocumento))
  }
  /** Collection-like TableQuery object for table Personas */
  lazy val Personas = new TableQuery(tag => new Personas(tag))
}