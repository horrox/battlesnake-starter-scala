# Battlesnake Scala Starter

This is a starter project for buildling a [battlesnake](https://play.battlesnake.com) in Scala. It uses
[Finch](https://github.com/finagle/finch), a lightweight HTTP framework built on top of Finagle by Twitter.

## Getting Started

Install Scala using these [Getting Started](https://docs.scala-lang.org/getting-started/index.html) instructions.
This will install Java, the Scala compiler and sbt, the Scala Build Tool. You can also use an IDE like
[IntelliJ](https://www.jetbrains.com/idea/).

After installing software and cloning the repository, you can run the project as is.
```shell script
  $ sbt run
    OpenJDK 64-Bit Server VM warning: ignoring option MaxPermSize=4G; support was removed in 8.0
    [info] Loading global plugins from plugins
    [info] Loading settings for project battlesnake-starter-scala-build from plugins.sbt ...
    [info] Loading project definition from battlesnake-starter-scala/project
    [info] Loading settings for project root from build.sbt ...
    [info] Set current project to battlesnake-starter-scala (in build file:battlesnake-starter-scala/)
    [info] Running starter.Main
    Oct 25, 2020 3:29:07 AM com.twitter.finagle.Init$ $anonfun$once$1
    INFO: Finagle version 18.11.0 (rev=884a4c5e4a4e9e0245e3144f083597b5fb0f0cab) built at 20181112-122451
```

You can also run automated test by running this command
```shell script
 $ sbt test
    OpenJDK 64-Bit Server VM warning: ignoring option MaxPermSize=4G; support was removed in 8.0
    [info] Loading global plugins from plugins
    [info] Loading settings for project battlesnake-starter-scala-build from plugins.sbt ...
    [info] Loading project definition from battlesnake-starter-scala/project
    [info] Loading settings for project root from build.sbt ...
    [info] Set current project to battlesnake-starter-scala (in build file:battlesnake-starter-scala/)
    [info] Compiling 2 Scala sources to battlesnake-starter-scala/target/scala-2.12/test-classes ...
    [info] Done compiling.
    [info] MainSpec:
    [info] Main
    [info] - should share server info
    [info] - should respond to move
    [info] - should respond to start
    [info] - should respond to end
    [info] Run completed in 922 milliseconds.
    [info] Total number of tests run: 4
    [info] Suites: completed 1, aborted 0
    [info] Tests: succeeded 4, failed 0, canceled 0, ignored 0, pending 0
    [info] All tests passed.
    [success] Total time: 9 s, completed Oct 25, 2020 3:31:51 AM
```
## Deployment

This starter project has deployment configured for Heroku. It's one of the few places that runs Scala projects
for free. `Procfile` in the root directory is a Heroku configuration file that runs a staged executable. Heroku
can be connected to a GitHub respository so that each commit automatically builds and deploys the project.

Installing the [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli) allows users to
interact with their running projects either via web interface or command line. For example, you can view logs
of the running project by typing the following.
```shell script
    $ heroku logs --app battlesnake-starter-scala
```

To build the same kind of executable locally, execute the following commands in the `sbt` shell.
```sbtshell
    > stage
    > run
```

You can also run directly using Heroku like this.
```shell script
    $ heroku local
```
## Contributing

All contributions to date have been made by the author. Feel free to start a pull request at
https://github.com/horrox/battlesnake-starter-scala.

## License

MIT License

Copyright (c) 2020 Tyson Horrocks

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.