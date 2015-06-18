package persistence.postgresql
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.PostgresDriver
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
   *  @param cdempresas Database column cdempresas DBType(serial), AutoInc, PrimaryKey
   *  @param tipoDocumento Database column tipo_documento DBType(varchar), Length(2,true)
   *  @param numeroDocumento Database column numero_documento DBType(varchar), Length(20,true)
   *  @param razonSocial Database column razon_social DBType(varchar), Length(200,true)
   *  @param tipoEmpresa Database column tipo_empresa DBType(varchar), Length(1,true)
   *  @param fechaCreacion Database column fecha_creacion DBType(date)
   *  @param fechaRegistro Database column fecha_registro DBType(timestamp)
   *  @param idAdministrador Database column id_administrador DBType(int4) */
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
    
    /** Database column cdempresas DBType(serial), AutoInc, PrimaryKey */
    val cdempresas: Column[Int] = column[Int]("cdempresas", O.AutoInc, O.PrimaryKey)
    /** Database column tipo_documento DBType(varchar), Length(2,true) */
    val tipoDocumento: Column[String] = column[String]("tipo_documento", O.Length(2,varying=true))
    /** Database column numero_documento DBType(varchar), Length(20,true) */
    val numeroDocumento: Column[String] = column[String]("numero_documento", O.Length(20,varying=true))
    /** Database column razon_social DBType(varchar), Length(200,true) */
    val razonSocial: Column[String] = column[String]("razon_social", O.Length(200,varying=true))
    /** Database column tipo_empresa DBType(varchar), Length(1,true) */
    val tipoEmpresa: Column[String] = column[String]("tipo_empresa", O.Length(1,varying=true))
    /** Database column fecha_creacion DBType(date) */
    val fechaCreacion: Column[java.sql.Date] = column[java.sql.Date]("fecha_creacion")
    /** Database column fecha_registro DBType(timestamp) */
    val fechaRegistro: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("fecha_registro")
    /** Database column id_administrador DBType(int4) */
    val idAdministrador: Column[Int] = column[Int]("id_administrador")
    
    /** Foreign key referencing Personas (database name empresas_id_administrador_fkey) */
    lazy val personasFk = foreignKey("empresas_id_administrador_fkey", idAdministrador, Personas)(r => r.cdpersona, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Restrict)
    
    /** Uniqueness Index over (tipoDocumento,numeroDocumento) (database name empresas_UNIQUE_KEY) */
    val index1 = index("empresas_UNIQUE_KEY", (tipoDocumento, numeroDocumento), unique=true)
  }
  /** Collection-like TableQuery object for table Empresas */
  lazy val Empresas = new TableQuery(tag => new Empresas(tag))
  
  /** Entity class storing rows of table Personas
   *  @param cdpersona Database column cdpersona DBType(serial), AutoInc, PrimaryKey
   *  @param tipoDocumento Database column tipo_documento DBType(varchar), Length(2,true), Default(None)
   *  @param numeroDocumento Database column numero_documento DBType(varchar), Length(20,true)
   *  @param nombres Database column nombres DBType(varchar), Length(50,true), Default(None)
   *  @param apellidos Database column apellidos DBType(varchar), Length(50,true)
   *  @param sexo Database column sexo DBType(varchar), Length(1,true), Default(None)
   *  @param fechaNacimiento Database column fecha_nacimiento DBType(date)
   *  @param salario Database column salario DBType(float8) */
  case class PersonasRow(cdpersona: Int, tipoDocumento: Option[String] = None, numeroDocumento: String, nombres: Option[String] = None, apellidos: String, sexo: Option[String] = None, fechaNacimiento: java.sql.Date, salario: Double)
  /** GetResult implicit for fetching PersonasRow objects using plain SQL queries */
  implicit def GetResultPersonasRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[String], e3: GR[java.sql.Date], e4: GR[Double]): GR[PersonasRow] = GR{
    prs => import prs._
    PersonasRow.tupled((<<[Int], <<?[String], <<[String], <<?[String], <<[String], <<?[String], <<[java.sql.Date], <<[Double]))
  }
  /** Table description of table personas. Objects of this class serve as prototypes for rows in queries. */
  class Personas(_tableTag: Tag) extends Table[PersonasRow](_tableTag, "personas") {
    def * = (cdpersona, tipoDocumento, numeroDocumento, nombres, apellidos, sexo, fechaNacimiento, salario) <> (PersonasRow.tupled, PersonasRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (cdpersona.?, tipoDocumento, numeroDocumento.?, nombres, apellidos.?, sexo, fechaNacimiento.?, salario.?).shaped.<>({r=>import r._; _1.map(_=> PersonasRow.tupled((_1.get, _2, _3.get, _4, _5.get, _6, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column cdpersona DBType(serial), AutoInc, PrimaryKey */
    val cdpersona: Column[Int] = column[Int]("cdpersona", O.AutoInc, O.PrimaryKey)
    /** Database column tipo_documento DBType(varchar), Length(2,true), Default(None) */
    val tipoDocumento: Column[Option[String]] = column[Option[String]]("tipo_documento", O.Length(2,varying=true), O.Default(None))
    /** Database column numero_documento DBType(varchar), Length(20,true) */
    val numeroDocumento: Column[String] = column[String]("numero_documento", O.Length(20,varying=true))
    /** Database column nombres DBType(varchar), Length(50,true), Default(None) */
    val nombres: Column[Option[String]] = column[Option[String]]("nombres", O.Length(50,varying=true), O.Default(None))
    /** Database column apellidos DBType(varchar), Length(50,true) */
    val apellidos: Column[String] = column[String]("apellidos", O.Length(50,varying=true))
    /** Database column sexo DBType(varchar), Length(1,true), Default(None) */
    val sexo: Column[Option[String]] = column[Option[String]]("sexo", O.Length(1,varying=true), O.Default(None))
    /** Database column fecha_nacimiento DBType(date) */
    val fechaNacimiento: Column[java.sql.Date] = column[java.sql.Date]("fecha_nacimiento")
    /** Database column salario DBType(float8) */
    val salario: Column[Double] = column[Double]("salario")
    
    /** Uniqueness Index over (tipoDocumento,numeroDocumento) (database name UNIQUE_KEY) */
    val index1 = index("UNIQUE_KEY", (tipoDocumento, numeroDocumento), unique=true)
  }
  /** Collection-like TableQuery object for table Personas */
  lazy val Personas = new TableQuery(tag => new Personas(tag))
}