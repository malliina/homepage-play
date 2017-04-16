import sbt._
import sbt.Keys._

object BuildBuild {
  // "build.sbt" goes here
  lazy val settings = Seq(
    scalaVersion := "2.10.6",
    resolvers ++= Seq(
      Resolver.url("malliina bintray sbt", url("https://dl.bintray.com/malliina/sbt-plugins/"))(Resolver.ivyStylePatterns),
      Resolver.bintrayRepo("malliina", "maven")
    ),
    scalacOptions ++= Seq("-unchecked", "-deprecation")
  ) ++ sbtPlugins

  def sbtPlugins = Seq(
    "com.malliina" %% "sbt-play" % "0.9.7"
  ) map addSbtPlugin
}
