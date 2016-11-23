package controllers

import play.api.libs.json.Json
import play.api.mvc._
import views._

class Home extends Controller {
  def ping = Action(Ok(Json.obj("status" -> "ok"))
    .withHeaders(CACHE_CONTROL -> "no-cache"))

  def index = Action(Ok(html.home()))
}
