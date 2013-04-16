import java.nio.file.Paths
import sbt._
import sbt.Keys._
import Dependencies._
import com.mle.sbt.cloud._

object HomeBuild extends Build {
  lazy val homepage = play.Project("homepage",
    path = file("."),
    applicationVersion = "0.1",
    dependencies = Seq(scalaTest),
    settings = commonSettings
  )
  // Hack for play compat
  override def settings = super.settings ++ com.typesafe.sbtidea.SbtIdeaPlugin.ideaSettings

  val commonSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion := "2.10.0",
    retrieveManaged := false,
    sbt.Keys.fork in Test := true,
    resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
    HerokuKeys.heroku := Paths.get( """C:\Program Files (x86)\Heroku\bin\heroku.bat""")
  ) ++ HerokuPlugin.settings
}