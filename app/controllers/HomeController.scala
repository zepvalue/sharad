package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import daos.AdDAO
import models.Ad
import play.api.libs.json.Json


import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents)(implicit ec: ExecutionContext) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def test() = Action { implicit request: Request[AnyContent] => 
      // adDAO.list().map { ads =>
      //   Ok(views.html.list(ads))

        val ads: Seq[String] = Seq("Item 1", "Item 2", "Item 3")
        val htmlContent = views.html.list(ads)
        Ok(htmlContent)
    
  }
 
}