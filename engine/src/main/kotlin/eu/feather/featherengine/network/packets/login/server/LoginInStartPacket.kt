package eu.feather.featherengine.network.packets.login.server

import eu.feather.featherengine.network.packets.parser.PacketReader
import eu.feather.featherengine.network.packets.parser.PacketWriter
import eu.feather.featherengine.network.readString
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

data class LoginInStartPacket(
    val username: String
) {
    companion object : PacketReader<LoginInStartPacket> {

        override suspend fun ByteReadChannel.read() =
            LoginInStartPacket(
                username = readString()
            )

    }
}