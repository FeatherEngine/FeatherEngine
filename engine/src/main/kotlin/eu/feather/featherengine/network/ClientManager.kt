package eu.feather.featherengine.network

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.net.ServerSocket
import java.net.Socket
import kotlin.coroutines.CoroutineContext

class ClientManager(
    private val context: CoroutineContext
) {

    private val jobs = mutableListOf<Job>()
    val clients = mutableListOf<ConnectedClient>()

    fun listen() {
        runBlocking(context) {
            val serverSocket = ServerSocket(8080)
            while (true) {
                try {
                    jobs.add(
                        launch {
                            handleClient(serverSocket.accept())
                        })
                } catch (throwable: Throwable) {
                    throwable.printStackTrace()
                }
            }
        }
    }

    private fun handleClient(socket: Socket) {

    }
}