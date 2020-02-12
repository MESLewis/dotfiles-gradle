import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputFile
import java.io.File

class FileLinkTask : DefaultTask() {
    var destination: Any? = null

    @OutputFile
    fun getDestination(): File {
        println(destination)
        return project.file(destination!!)
    }
}