package homepage

import controllers.{Assets, Home}
import play.api.ApplicationLoader.Context
import play.api.{ApplicationLoader, BuiltInComponentsFromContext, LoggerConfigurator}
import router.Routes

class AppLoader extends ApplicationLoader {
  override def load(context: Context) = {
    val env = context.environment
    LoggerConfigurator(env.classLoader)
      .foreach(_.configure(env))
    new AppComponents(context).application
  }
}

class AppComponents(context: Context) extends BuiltInComponentsFromContext(context: Context) {
  override def router = new Routes(httpErrorHandler, new Home, new Assets(httpErrorHandler))
}
