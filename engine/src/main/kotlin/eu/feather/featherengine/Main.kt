package eu.feather.featherengine

import eu.feather.featherengine.network.ClientManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        newSingleThreadContext("networking").use { ctx ->
            ClientManager(ctx).listen()
        }
    }
}