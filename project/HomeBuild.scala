import play.routes.compiler.InjectedRoutesGenerator
import play.sbt.PlayScala
import play.sbt.routes.RoutesKeys
import sbt.Keys._
import sbt._

object HomeBuild {
  lazy val homepage = Project("homepage", file("."), settings = commonSettings)
    .enablePlugins(PlayScala)

  val commonSettings = Seq(
    scalaVersion := "2.11.8",
    version := "1.2.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % Test,
    RoutesKeys.routesGenerator := InjectedRoutesGenerator
  )
}
