
tasks.register<DotfileTask>("nvim") {
    source = "."
    destination = "~/AppData/Local/nvim"
}

tasks.register<DotfileTask>("nvim-data") {
    source = "nvim-data"
    destination = "~/AppData/Local/nvim-data"
}
