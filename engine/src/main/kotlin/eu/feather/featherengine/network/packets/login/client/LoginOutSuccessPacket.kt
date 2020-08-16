package eu.feather.featherengine.network.packets.login.client

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.writeStringUtf8
import java.util.*

data class LoginOutSuccessPacket(
    val uuid: UUID,
    val username: String
) {
    companion object : PacketParser<LoginOutSuccessPacket> {

        override suspend fun ByteWriteChannel.write(t: LoginOutSuccessPacket) {
            writeStringUtf8(t.uuid.toString())
            writeStringUtf8(t.username)
        }

        override suspend fun ByteReadChannel.read(): LoginOutSuccessPacket {
            TODO("Client bound packet")
        }

    }
}