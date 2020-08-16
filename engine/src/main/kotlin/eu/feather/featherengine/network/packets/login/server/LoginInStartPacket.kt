package eu.feather.featherengine.network.packets.login.server

import eu.feather.featherengine.network.packets.parser.PacketParser
import eu.feather.featherengine.network.readString
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

data class LoginInStartPacket(
    val username: String
) {
    companion object : PacketParser<LoginInStartPacket> {

        override suspend fun ByteWriteChannel.write(t: LoginInStartPacket) {
            TODO("Server bound packet")
        }

        override suspend fun ByteReadChannel.read() =
            LoginInStartPacket(
                username = readString()
            )

    }
}