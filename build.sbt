import bintray.Keys._

name := "akka-http-metrics_akka23"

organization := "backline"

version := "0.3.0"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.6", "2.11.8")

val akkaVersion = "2.0.4"

resolvers ++= Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= Seq(
  "io.dropwizard.metrics" % "metrics-core" % "3.1.2",
  "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
  "com.typesafe.akka" %% "akka-http-core-experimental" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream-experimental" % akkaVersion
)

resolvers ++= Seq(
  "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
)

scalacOptions in Test ++= Seq("-Yrangepos")

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.7" % "test",
  "com.typesafe.akka" %% "akka-http-testkit-experimental" % akkaVersion % "test"
)

bintrayOrganization in bintray := Some("banno")

bintrayPublishSettings ++ Seq(
  publishArtifact in Test := false,
  repository in bintray := "oss",
  homepage := Some(url("https://github.com/backline/akka-http-metrics")),
  licenses ++= Seq(("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html")))
)
