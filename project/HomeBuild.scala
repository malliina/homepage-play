import com.malliina.sbt.unix.LinuxKeys._
import com.malliina.sbt.unix.LinuxPlugin
import com.malliina.sbtplay.PlayProject
import com.typesafe.sbt.SbtNativePackager.{Debian, Linux, Universal}
import com.typesafe.sbt.packager.Keys.{maintainer, serverLoading}
import com.typesafe.sbt.packager.archetypes.{JavaServerAppPackaging, ServerLoader}
import sbt.Keys._

object HomeBuild {
  lazy val homepage = PlayProject.default("homepage")
    .enablePlugins(JavaServerAppPackaging)
    .settings(commonSettings: _*)

  val commonSettings = linuxSettings ++ Seq(
    scalaVersion := "2.11.8",
    version := "1.3.2"
  )

  def linuxSettings = {
    LinuxPlugin.playSettings ++ Seq(
      httpPort in Linux := Option("8461"),
      httpsPort in Linux := Option("disabled"),
      maintainer := "Michael Skogberg <malliina123@gmail.com>",
      javaOptions in Universal ++= {
        Seq(
          "-Dfile.encoding=UTF-8",
          "-Dsun.jnu.encoding=UTF-8"
        )
      },
      serverLoading in Debian := ServerLoader.Systemd
    )
  }
}
