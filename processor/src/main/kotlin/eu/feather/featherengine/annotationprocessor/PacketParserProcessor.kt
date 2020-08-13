package eu.feather.featherengine.annotationprocessor

import com.google.auto.service.AutoService
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.jvm.jvmWildcard
import eu.feather.featherengine.annotations.PacketParser
import eu.feather.featherengine.annotations.VarInt
import io.ktor.utils.io.ByteReadChannel
import java.io.File
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement
import javax.lang.model.type.TypeKind
import javax.tools.Diagnostic

@ExperimentalStdlibApi
@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedOptions(PacketParserProcessor.KAPT_KOTLIN_GENERATED_OPTION_NAME)
@SupportedAnnotationTypes()
class PacketParserProcessor : AbstractProcessor() {

    companion object {
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
        const val CORE_PACKAGE = "eu.feather.featherengine.network.packets"
    }

    private val generatedSourcesRoot by lazy { processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME]!! }


    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(PacketParser::class.java.canonicalName)
    }

    override fun process(p0: MutableSet<out TypeElement>, roundEnvironment: RoundEnvironment): Boolean {
        if (generatedSourcesRoot.isEmpty()) {
            processingEnv.messager.printMessage(
                Diagnostic.Kind.ERROR,
                "Can't find the target directory for generated Kotlin files."
            )
            return false
        }
        roundEnvironment.getElementsAnnotatedWith(PacketParser::class.java).forEach {
            if (it.kind != ElementKind.CLASS) {
                processingEnv.messager.printMessage(
                    Diagnostic.Kind.ERROR,
                    "Can only be applied to functions,  element: $it "
                )
                return false
            }


            /* val generatedSourcesRoot = processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME].orEmpty()
             if (generatedSourcesRoot.isEmpty()) {
                 processingEnv.messager.printMessage(
                     Diagnostic.Kind.ERROR,
                     "Can't find the target directory for generated Kotlin files."
                 )
                 return false
             }*/
            processAnnotation(it)
        }
        return false
    }

    private fun processAnnotation(element: Element) {
        val className = element.simpleName.toString()
        val pack = processingEnv.elementUtils.getPackageOf(element).toString()

        val fileName = "Extension$className"
        val fileBuilder = FileSpec.builder(pack, fileName)
        fileBuilder.addImport("eu.feather.featherengine.network", "readVarInt")
        //fileBuilder.addImport("")
        val funSpec = FunSpec.builder("parse")
        funSpec.receiver(ClassName(CORE_PACKAGE, className))
        funSpec.addModifiers(KModifier.SUSPEND)
        funSpec.addParameter(ParameterSpec("channel", typeNameOf<ByteReadChannel>()))
        val elements = element.enclosedElements.filter { it.kind == ElementKind.FIELD }
        elements.forEachIndexed { index, it ->
            when (it.asType().kind) {
                TypeKind.INT -> {
                    if (it.getAnnotation(VarInt::class.java) != null) {
                        funSpec.addStatement(
                            statement(it, "readVarInt", elements.size - 1 == index)
                        )
                    } else {
                        funSpec.addStatement(
                            statement(it, "readInt", elements.size - 1 == index)
                        )

                    }
                }
            }

        }
        println("XD writing1")
        val file = File(generatedSourcesRoot)
        println("XD writing2")

        file.mkdirs()
        println("XD writing3")
        file.mkdir()
        fileBuilder.addFunction(funSpec.build())
        println("XD writing4")
        try {
            println(file.exists())
            fileBuilder.build().writeTo(file)
            println("XD writing5")
        } catch (exception: Exception) {
            println(exception.printStackTrace())
        }

    }

    private fun statement(element: Element, function: String, addComma: Boolean): String {
        return "${element.simpleName} = channel.${function}()${if (addComma) "," else ""}"
    }

}