import java.nio.file.Paths
import sbt._
import sbt.Keys._
import com.mle.sbt.cloud._

object HomeBuild extends Build {
  lazy val homepage = Project("homepage", file("."), settings = commonSettings)

  val commonSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion := "2.10.4",
    version := "1.1.1",
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.3" % "test",
    retrieveManaged := false,
    sbt.Keys.fork in Test := true,
    resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
    HerokuKeys.heroku := Paths.get( """C:\Program Files (x86)\Heroku\bin\heroku.bat""")
  ) ++ HerokuPlugin.settings ++ play.Project.playScalaSettings

}