import org.gradle.api.tasks.AbstractExecTask
import org.gradle.api.tasks.TaskAction

open class CommandTask : AbstractExecTask<CommandTask>(CommandTask::class.java) {

    init {
        group = "dotfiles.command"
    }

    @TaskAction
    fun runCommand() {
        super.exec()
    }
}