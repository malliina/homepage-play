import com.malliina.sbt.unix.LinuxKeys._
import com.malliina.sbt.unix.LinuxPlugin
import com.malliina.sbtplay.PlayProject
import com.typesafe.sbt.SbtNativePackager.Linux
import com.typesafe.sbt.packager.Keys.maintainer
import sbt.Keys._

object HomeBuild {
  lazy val homepage = PlayProject.default("homepage")
    .settings(commonSettings: _*)

  val commonSettings = linuxSettings ++ Seq(
    scalaVersion := "2.11.8",
    version := "1.3.4"
  )

  def linuxSettings = {
    LinuxPlugin.playSettings ++ Seq(
      httpPort in Linux := Option("8461"),
      httpsPort in Linux := Option("disabled"),
      maintainer := "Michael Skogberg <malliina123@gmail.com>"
    )
  }
}
