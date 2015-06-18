name := "MySlick"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies ++= List(
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.h2database" % "h2" % "1.3.170",
  "org.scalatest" %% "scalatest" % "2.0" % "test",
  "mysql" % "mysql-connector-java" % "5.1.12",
  "com.typesafe.slick" %% "slick-codegen" % "2.1.0-RC3",
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc4"
)

