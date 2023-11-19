package models

import slick.jdbc.SQLiteProfile.api._
import play.api.libs.json.Writes
import play.api.libs.json._

case class Ad(id: Option[Int], title: String)

object Ad {
  implicit val adWrites: Writes[Ad] = new Writes[Ad] {
    def writes(ad: Ad): JsObject = Json.obj(
      
      "title" -> ad.title
    )
  }
  implicit val adReads: Reads[Ad] = Json.reads[Ad]

  def validate(json: JsValue): Option[Ad] = {
    json.validate[Ad].asOpt
  }
}

class AdTable(tag: Tag) extends Table[Ad](tag, "Ads") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def title = column[String]("title")

  override def * = (id.?, title) <> ((Ad.apply _).tupled, Ad.unapply _)
}
