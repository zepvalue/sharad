package models

import slick.jdbc.SQLiteProfile.api._

case class Ad(id:Long, title: String )

class AdTable(tag:Tag) extends Table[Ad](tag, "Ads") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def title = column[String]("title")

    override def * = (id, title) <> (Ad.tupled, Ad.unapply)
}

