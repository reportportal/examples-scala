import sbt.Keys.testOptions

ThisBuild / name := "examples-scala"
ThisBuild / organization := "com.epam.reportportal"
ThisBuild / scalaVersion := "2.12.10"
ThisBuild / licenses := Seq("Apache-2.0" -> url("https://opensource.org/licenses/Apache-2.0"))

lazy val dependencies =
  new {
    val scalatestVersion = "3.0.8"
    val scalatestAgentVersion = "5.0.3"
    val loggerLogbackVersion = "5.0.0-BETA-8"
    val logbackVersion = "1.2.10"
    val slf4jVersion = "1.7.32"
    val seleniumVersion = "2.3.1"
    val selenideVersion = "5.2.8"
    val junitVersion = "4.12"
    val cucumberVersion = "4.7.1"
    val cucumber4AgentVersion = "5.0.0-BETA-1"
    val junitInterfaceVersion = "0.11"

    val loggerLogback = "com.epam.reportportal" % "logger-java-logback" % loggerLogbackVersion
    val logback = "ch.qos.logback" % "logback-classic" % logbackVersion
    val slf4j = "org.slf4j" % "jul-to-slf4j" % slf4jVersion

    val scalatest = "org.scalatest" %% "scalatest" % scalatestVersion % "test"
    val scalatestAgent = "com.epam.reportportal" %% "agent-scala-scalatest" % scalatestAgentVersion % "test"

    val selenium = "org.seleniumhq.selenium" % "selenium-chrome-driver" % seleniumVersion
    val selenide = "com.codeborne" % "selenide" % selenideVersion
    val cucumberJava = "io.cucumber" % "cucumber-java" % cucumberVersion
    val cucumberJunit = "io.cucumber" % "cucumber-junit" % cucumberVersion % "test"
    val cucumberAgent = "com.epam.reportportal" % "agent-java-cucumber4" % cucumber4AgentVersion % "test"
    val junitInterface = "com.novocode" % "junit-interface" % junitInterfaceVersion % "test"
  }

lazy val commonDependencies = Seq(
  dependencies.loggerLogback,
  dependencies.logback,
  dependencies.slf4j
)

lazy val javaCompilerOptions = Seq("-source", "1.8", "-target", "1.8", "-Xlint")
lazy val commonResolvers = Seq(
  Resolver.jcenterRepo,
  "EPAM bintray" at "https://dl.bintray.com/epam/reportportal"
)

lazy val commonSettings = Seq(
  javacOptions ++= javaCompilerOptions,
  resolvers ++= commonResolvers,
  parallelExecution := false,
  logBuffered := false
)

lazy val exampleCommon = project
  .in(file("example-common"))
  .settings(
    name := "example-common",
    commonSettings,
    libraryDependencies ++= commonDependencies
  )

lazy val exampleScalatest = project
  .in(file("example-scalatest"))
  .settings(
    name := "example-scalatest",
    commonSettings,
    libraryDependencies ++= commonDependencies ++
      Seq(
        dependencies.scalatest,
        dependencies.scalatestAgent
      ),
    testOptions ++= Seq(
      Tests.Argument(TestFrameworks.ScalaTest, "-C", "com.epam.reportportal.scalatest.RPReporter")
    )
  ).dependsOn(exampleCommon)

lazy val exampleCucumber = project
  .in(file("example-cucumber"))
  .settings(
    name := "example-cucumber",
    commonSettings,
    libraryDependencies ++= commonDependencies ++
      Seq(
        dependencies.selenium,
        dependencies.selenide,
        dependencies.cucumberJava,
        dependencies.cucumberJunit,
        dependencies.cucumberAgent,
        dependencies.junitInterface
      ),
    testOptions ++= Seq(
      Tests.Argument(TestFrameworks.JUnit, "-v")
    )
  ).dependsOn(exampleCommon)

lazy val examplesScala = project
  .in(file("."))
  .settings(
    name := "examples-scala",
    commonSettings
  )
  .aggregate(
    exampleCommon,
    exampleScalatest,
    exampleCucumber
  )
