package eu.feather.featherengine.network.packets.login.client

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.writeStringUtf8

data class LoginOutDisconnectPacket(
    val reason: String
) {
    companion object : PacketParser<LoginOutDisconnectPacket> {

        override suspend fun ByteWriteChannel.write(t: LoginOutDisconnectPacket) {
            writeStringUtf8(t.reason)
        }

        override suspend fun ByteReadChannel.read(): LoginOutDisconnectPacket {
            TODO("Client bound packet")
        }

    }
}