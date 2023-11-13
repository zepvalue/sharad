name := """sharad"""
organization := "com.zepvalue"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
    guice,
    "org.playframework" %% "play-slick" % "6.0.0-M2",
    "org.playframework" %% "play-slick-evolutions" % "6.0.0-M2",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "org.xerial" % "sqlite-jdbc" % "3.34.0" // SQLite JDBC driver
) 

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.zepvalue.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.zepvalue.binders._"
