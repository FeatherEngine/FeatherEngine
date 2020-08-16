package eu.feather.featherengine.network

import eu.feather.featherengine.architecture.parse
import eu.feather.featherengine.architecture.write
import eu.feather.featherengine.network.client.ConnectedClient
import eu.feather.featherengine.network.packets.handshake.HandshakePacket
import io.ktor.network.selector.ActorSelectorManager
import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.aSocket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel
import io.ktor.utils.io.core.readBytes
import io.ktor.utils.io.readPacket
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import java.net.InetSocketAddress
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

class ClientManager(
    private val context: CoroutineContext
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    private val jobs = mutableListOf<Job>()
    val clients = mutableListOf<ConnectedClient>()
    val exec = Executors.newCachedThreadPool()
    val selector = ActorSelectorManager(exec.asCoroutineDispatcher())

    suspend fun listen() {
        coroutineScope {
            val server = aSocket(selector).tcp().bind(InetSocketAddress("127.0.0.1", 25565))
            while (true) {
                val socket = server.accept()
                launch {
                    handleClient(socket)
                }
            }
        }

    }

    private suspend fun handleClient(client: Socket) {
        logger.debug("client connected: ${client.remoteAddress}")
        val input = client.openReadChannel()
        val output = client.openWriteChannel()
        try {
            while (true) {
                val length = input.readVarInt()
                logger.debug("${client.remoteAddress}: $length")
                val packetId = input.readVarInt()
                logger.debug("${client.remoteAddress}: $packetId")
                val content = input.readPacket(length).readBytes()
                logger.debug("${content.contentToString()} content of the packet")
                input.readInt()
                input.parse(HandshakePacket)
                output.write(HandshakePacket(10), HandshakePacket)
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            client.close()
        }
    }

}