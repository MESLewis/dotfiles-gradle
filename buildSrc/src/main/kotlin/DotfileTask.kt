import groovy.cli.Option
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.internal.os.OperatingSystem

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
        println("Running on $os moving file from $source to $destination")
    }
}