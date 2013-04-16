package controllers

import play.api.mvc._
import views._


/**
 *
 * @author mle
 */
object Home extends Controller {
  def index = Action(Ok(html.home()))
}
