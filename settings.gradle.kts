import org.gradle.internal.impldep.org.bouncycastle.asn1.x500.style.RFC4519Style.name
import java.io.FileFilter
import java.io.FilenameFilter

/*
 * The settings file is used to specify which projects to include in your build.
 */
rootProject.name = "dotfiles"

discoverBuilds(rootProject.projectDir, "")

fun discoverBuilds(dir : File, include : String) {
    if(dir.isDirectory) {
        dir.listFiles{file, name -> filterFiles(file, name)}.forEach { subdir ->
            discoverBuilds(subdir, dir.name)
        }
    }
    if(dir.isFile && dir.name.contains(".gradle")) {
        if(!include.startsWith('.')) {
            include(include)
        }
    }
}

fun filterFiles(file : File, name : String) : Boolean {
    when(name) {
        ".git" -> return false
        ".idea" -> return false
        ".gradle" -> return false
        "buildSrc" -> return false
        "gradle" -> return false
    }
    return !name.startsWith('.')
}
