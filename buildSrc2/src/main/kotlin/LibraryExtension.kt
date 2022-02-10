import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion

fun BaseAppModuleExtension.applyConfig() {
    print("Log test 12345")
    compileSdk = 31
}

//fun applyConfig() {
//    print("Log test 12345")
//}