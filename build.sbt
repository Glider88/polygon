import com.lihaoyi.workbench.WorkbenchBasePlugin.autoImport.{workbenchDefaultRootObject, workbenchStartMode}
import org.scalajs.sbtplugin.ScalaJSPlugin.AutoImport.scalaJSMainModuleInitializer
import sbt.Keys.mainClass
//enablePlugins(ScalaJSPlugin, WorkbenchPlugin)

ThisBuild / scalaVersion     := "2.13.0"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .aggregate(client, server)

lazy val client = (project in file("app/client"))
  .settings(
    name := "client-polygon",
    scalaJSUseMainModuleInitializer := true,
    mainClass in Compile := Some("client.Playground"),
    scalaJSMainModuleInitializer in Compile := Some(
      org.scalajs.core.tools.linker.ModuleInitializer.mainMethodWithArgs("client.Playground", "main")
    ),
    workbenchDefaultRootObject := Some(("app/client/target/scala-2.13/classes/index-dev.html", "app/client/target/scala-2.13/")), // (defaultRootObject, rootDirectory)
    workbenchStartMode := WorkbenchStartModes.OnCompile,
    libraryDependencies ++= Dependencies.scalaJsDependencies.value,
  ).enablePlugins(ScalaJSPlugin, WorkbenchPlugin)

lazy val server = (project in file("app/server"))
  .settings(
    name := "server-polygon",
    libraryDependencies ++= Dependencies.akkaDependencies.value,
  )