package me.amutake.ms

import com.typesafe.config.ConfigFactory
import scala.collection.JavaConversions._

import arisa.backend.microsoftacademic.db.Tables
import arisa.backend.microsoftacademic.types.UnattendedPaper

import scala.slick.driver.MySQLDriver.simple._


object Main {

  def main(args: Array[String]) = {

    val config = ConfigFactory.load()

    val url = config.getString("db.url")
    val user = config.getString("db.user")
    val password = config.getString("db.password")

    Database.forURL(
      url,
      user = user,
      password = password,
      driver = "com.mysql.jdbc.Driver"
    ).withSession { implicit session =>
      Tables.unattendedPapers.ddl.create
      Tables.papers.foreach { p =>
        Tables.unattendedPapers += UnattendedPaper(0, p.id)
      }
    }
  }
}
