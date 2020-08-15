package eu.feather.featherengine.network.packets

import eu.feather.featherengine.network.packets.parser.PacketParser
import eu.feather.featherengine.network.readString
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

data class LoginInStartPacket(
    val playerName: String
) {
    companion object : PacketParser<LoginInStartPacket> {

        override suspend fun ByteWriteChannel.write(t: LoginInStartPacket) { }

        override suspend fun ByteReadChannel.read() = LoginInStartPacket(
            playerName = readString()
        )

    }
}