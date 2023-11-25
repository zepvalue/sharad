package daos

import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import models.{Ad, AdTable}
import slick.jdbc.JdbcProfile
import scala.concurrent.{ExecutionContext, Future}

class AdDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(
    implicit executionContext: ExecutionContext
) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val ads = TableQuery[AdTable]

  def insert(title: String): Future[Ad] = {
    val insertQuery = (ads.map(_.title) returning ads.map(_.id)) += title
    db.run(insertQuery).map(generatedId => Ad(Some(generatedId), title))
  }
  def list(): Future[Seq[Ad]] = db.run(ads.result)
  def delete(id: Int): Future[Int] = {
    val deleteQuery = ads.filter(_.id === id).delete
    db.run(deleteQuery)
  }
}
