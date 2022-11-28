import Dependencies._

ThisBuild / scalaVersion := "3.2.1"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "dev.maik"
ThisBuild / organizationName := "adventofcode"

lazy val root = (project in file("."))
  .settings(
    name := "Advent of Code",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "org.scala-lang" % "scala-reflect" % "2.13.10",
    )
  )
