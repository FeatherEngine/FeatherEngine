package eu.feather.featherengine

import eu.feather.featherengine.network.ClientManager
import io.ktor.util.InternalAPI
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        newSingleThreadContext("networking").use { ctx ->
            GlobalScope.launch(ctx) {
                ClientManager(ctx).listen()
            }
        }
        while (true) {
            sleep(1000)
        }
        val input = readLine()
        println("closing")
    }
}