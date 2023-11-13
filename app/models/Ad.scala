package models

import slick.jdbc.SQLiteProfile.api._

case class Ad(id:Long, name: String )

class AdTable(tag:Tag) extends Table[Ad](tag, "ad") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def title = column[String]("title")

    override def * = (id, title) <> (Ad.tupled, Ad.unapply)
}

