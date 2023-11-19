package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import daos.AdDAO
import models.{ Ad, AdJsonSerialization }
import play.api.libs.json._


import scala.concurrent.{ExecutionContext, Future}


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents, adDAO: AdDAO)(implicit ec: ExecutionContext) extends BaseController {

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

  def test() = Action.async { implicit request: Request[AnyContent] =>
     adDAO.list().map { ads =>
      Ok(Json.toJson(ads))
    }
  }
}