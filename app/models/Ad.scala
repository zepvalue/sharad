package models

import slick.jdbc.SQLiteProfile.api._
import play.api.libs.json.Writes
import play.api.libs.json._


case class Ad(id:Long, title: String )

object Ad {
  implicit val adWrites: Writes[Ad] = new Writes[Ad] {
    def writes(ad: Ad): JsObject = Json.obj(
      "id" -> ad.id,
      "title" -> ad.title,
    )
  }
}

class AdTable(tag:Tag) extends Table[Ad](tag, "Ads") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def title = column[String]("title")

    override def * = (id, title) <> ((Ad.apply _).tupled, Ad.unapply)
}

