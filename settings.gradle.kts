dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "SampleMultiModuleProject"
include(":app")
include(":network")
include(":module-injector")
include(":feature-memes")
include(":feature-news")
include(":feature-photo")
include(":navigation")
include(":core")
include(":app-theme")
