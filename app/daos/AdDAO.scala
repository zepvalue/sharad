package daos

import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import models.{Ad, AdTable}
import slick.jdbc.JdbcProfile
import scala.concurrent.{ExecutionContext, Future}

class AdDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {
    import profile.api._
    
    val ads = TableQuery[AdTable]

    def insert(ad: Ad): Future[Unit] = db.run(ads += ad).map(_ => ())
    def list(): Future[Seq[Ad]] = db.run(ads.result)

}
