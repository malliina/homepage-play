package controllers

import play.api.mvc._
import views._
import play.api.libs.json.Json


/**
 *
 * @author mle
 */
object Home extends Controller {
  def ping = Action(Ok(Json.obj("status" -> "ok"))
    .withHeaders(CACHE_CONTROL -> "no-cache"))

  def index = Action(Ok(html.home()))
}
