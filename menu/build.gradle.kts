val mindustryVersion = ext.get("mindustry-version")

dependencies {
    implementation(project(":bundles"))
    compileOnly("com.github.Anuken.Arc:arc-core:$mindustryVersion")
    compileOnly("com.github.Anuken.MindustryJitpack:core:$mindustryVersion")
}