import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskCollection
import org.gradle.internal.os.OperatingSystem
import org.gradle.kotlin.dsl.create

class DotfilesPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<DotfilesPluginExtension>("dotfiles")
        val installTask = project.task("install") {
            group = "dotfiles"
        }
        var dotfileTasks : TaskCollection<DotfileTask> = project.tasks.withType(DotfileTask::class.java)
        dotfileTasks.whenTaskAdded {
            installTask.dependsOn.add(this)
        }
    }
}

open class DotfilesPluginExtension {
    //TODO some useful settings per directory
    var os = listOf<OperatingSystem>()
    var message = "Hello test1"
}

