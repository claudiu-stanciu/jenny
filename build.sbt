import Dependencies._

ThisBuild / scalaVersion := "2.13.0"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.stejr"
ThisBuild / organizationName := "jenny"

lazy val runDeps = Seq(
  scalaLogging,
  logback,
  scalaCheck
)

lazy val testDeps = Seq(scalaTest).map(d => d % Test)

lazy val root = (project in file("."))
  .settings(
    name := "data-generator",
    libraryDependencies ++= runDeps ++ testDeps
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
