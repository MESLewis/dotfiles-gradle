import groovy.cli.Option
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.internal.os.OperatingSystem
import java.nio.file.Files
import java.nio.file.Paths

//TODO have this be subclassed for things like executing cmd lines
open class DotfileTask : DefaultTask() {
    @Option(description = "The operating system this task should apply to. Defaults to all.")
    @Input
    var os : OperatingSystem = OperatingSystem.current()
    @Option(description = "The location to create a link. Defaults to user home")
    @Input
    var destination = "~"
    @Option(description = "The folder or file to point the link to. Defaults to folder of this build file")
    @Input
    var source = "."

    init {
        group = "dotfiles"

    }

    @TaskAction
    fun createLink() {
        //projectDir = directory containing build script
        //path = absolute path of the project

        val sourceFile = project.file(source)
        val destFile = Paths.get(destination.replace("~", System.getProperty("user.home"))).toFile()

        if(!sourceFile.exists()) {
            println("File $sourceFile does not exist")
            return
        }
        if(!destFile.exists()) {
            println("Creating link at $destFile pointing to $sourceFile")
            Files.createSymbolicLink(destFile.toPath(), sourceFile.toPath())
//            Files.createLink(destFile.toPath(), sourceFile.toPath())
        } else {
            println("Link at $destFile already exists")
        }
    }
}