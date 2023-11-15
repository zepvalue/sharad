package models

import play.api.libs.json._

object AdJsonSerialization {
  implicit val adWrites: Writes[Ad] = new Writes[Ad] {
    def writes(ad: Ad): JsObject = Json.obj(
      "id" -> ad.id,
      "title" -> ad.title,
    )
  }
}