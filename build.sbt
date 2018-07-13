name := """pincette-jsontoxml"""
organization := "net.pincette"
version := "1.0.0"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.glassfish" % "javax.json" % "1.1.2",
  "net.pincette" % "pincette-common" % "1.2.7" withSources()
)

mainClass in assembly := Some("net.pincette.jsontoxml.Convert")
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
assemblyMergeStrategy in assembly := {
  case "module-info.class" => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

crossPaths := false
