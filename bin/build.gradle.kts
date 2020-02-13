tasks.register<CommandTask>("addBinToPath") {
    //TODO CASE WINDOWS
    workingDir(file("windows"))
    setIgnoreExitValue(true)
    commandLine("cmd", "/c", "call", file("windows/pathadd.bat").absolutePath, file("windows").absolutePath)
}