import com.malliina.sbt.unix.LinuxKeys._
import com.malliina.sbt.unix.LinuxPlugin
import com.malliina.sbtplay.PlayProject
import com.typesafe.sbt.SbtNativePackager.{Linux, Universal}
import com.typesafe.sbt.packager
import play.routes.compiler.InjectedRoutesGenerator
import play.sbt.routes.RoutesKeys
import sbt.Keys._
import sbt._

object HomeBuild {
  lazy val homepage = PlayProject.default("homepage")
    .settings(commonSettings: _*)

  val commonSettings = Seq(
    scalaVersion := "2.11.8",
    version := "1.3.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % Test,
    RoutesKeys.routesGenerator := InjectedRoutesGenerator
  )

  def linuxSettings = {
    LinuxPlugin.playSettings ++ Seq(
      httpPort in Linux := Option("disabled"),
      httpsPort in Linux := Option("8461"),
      packager.Keys.maintainer := "Michael Skogberg <malliina123@gmail.com>",
      javaOptions in Universal ++= {
        Seq(
          "-Dfile.encoding=UTF-8",
          "-Dsun.jnu.encoding=UTF-8"
        )
      }
    )
  }
}
