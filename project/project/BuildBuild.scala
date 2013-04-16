import sbt._
import sbt.Keys._

/**
 *
 * @author mle
 */
object WebBuildBuild extends Build {
  // "build.sbt" goes here
  override lazy val settings = super.settings ++ Seq(
    // play doesn't like 2.10 here
    scalaVersion := "2.9.2",
    resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
    resolvers += "Typesafe ivy releases" at "http://repo.typesafe.com/typesafe/ivy-releases/",
    resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
    scalacOptions ++= Seq("-unchecked", "-deprecation"),
    addSbtPlugin("play" % "sbt-plugin" % "2.1.1"),
    addSbtPlugin("com.github.malliina" %% "sbt-paas-deployer" % "0.102")
  )

  override lazy val projects = Seq(root)
  lazy val root = Project("plugins", file("."))
}
