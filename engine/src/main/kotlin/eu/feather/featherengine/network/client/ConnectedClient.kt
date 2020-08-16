package eu.feather.featherengine.network.client

import eu.feather.featherengine.architecture.parse
import eu.feather.featherengine.network.packets.handshake.HandshakePacket
import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.openReadChannel
import io.ktor.network.sockets.openWriteChannel

class ConnectedClient(
    socket: Socket
) {

    val input = socket.openReadChannel()
    val output = socket.openWriteChannel()

    var state = ConnectionState.HANDSHAKING

    suspend fun handle() {
        input.parse(HandshakePacket)
    }

}