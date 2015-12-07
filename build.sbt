name := """play-scala-intro"""

version := "1.0-SNAPSHOT"


libraryDependencies ++= Seq(
  // Reactive Mongo dependencies
  "org.reactivemongo" %% "play2-reactivemongo" % "0.10.2"
)


play.Project.playScalaSettings

