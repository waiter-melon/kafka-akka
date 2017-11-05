name := "kafka-akka"

version := "1.0"

scalaVersion := "2.12.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += Resolver.bintrayRepo("cakesolutions", "maven")

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.2"
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.5.2" % Test
libraryDependencies += "net.cakesolutions" %% "scala-kafka-client-akka" % "0.11.0.0"


