import sbt._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Dependencies {
  private val akkaVersion = "2.5.23"
  private val akkaHttpVersion = "10.1.9"
  private val scalaTestVersion = "3.0.8"
  private val scalaJsVersion = "0.9.7"
  private val scalaTagsVersion = "0.7.0"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion
  lazy val akkaHttp = "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  lazy val akkaStream = "com.typesafe.akka" %% "akka-stream" % akkaVersion
  lazy val akkaHttpTestKit = "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion
  lazy val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  lazy val akkaStreamTestKit = "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion
//  lazy val scalaJs = "org.scala-js" %%% "scalajs-dom" % scalaJsVersion
//  lazy val scalaTags = "com.lihaoyi" %%% "scalatags" % scalaTagsVersion

  val scalaJsDependencies = Def.setting(Seq(
    "org.scala-js" %%% "scalajs-dom" % scalaJsVersion,
    "com.lihaoyi" %%% "scalatags" % scalaTagsVersion
  ))

  val akkaDependencies = Def.setting(Seq(akkaActor, akkaHttp, akkaStream, scalaTest, akkaHttpTestKit, akkaStreamTestKit))
}
