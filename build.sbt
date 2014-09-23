name := """arisa-backend"""

version := "1.0"

scalaVersion := "2.11.2"

scalacOptions ++= Seq("-feature", "-deprecation")

libraryDependencies ++= Seq(
  // "ch.qos.logback" % "logback-classic" % "1.1.2",
  "com.typesafe" % "config" % "1.2.1"
)

lazy val microsoftAcademic = uri("ssh://git@github.com/white-chocolate/arisa-backend-microsoft-academic.git")

lazy val core = project.in(file(".")).dependsOn(microsoftAcademic)
