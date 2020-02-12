import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.os.OperatingSystem
import org.gradle.kotlin.dsl.create
import java.io.File

class DotfilesPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<DotfilesPluginExtension>("dotfiles")
        project.task("install") {
            doLast {
                println(extension.message)
            }
        }
    }

    fun gatherFiles() : List<File> {
        //TODO
        return emptyList()
    }

    fun currentOS() : OperatingSystem {
        return OperatingSystem.current()
    }
}

open class DotfilesPluginExtension {
    var os = listOf<OperatingSystem>()
    var message = "Hello test1"
}

