import org.gradle.api.Plugin
import org.gradle.api.Project

class DotfilesPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("hello") {
//            doLast {
                println("Hello plugin")
//            }
        }
    }
}
