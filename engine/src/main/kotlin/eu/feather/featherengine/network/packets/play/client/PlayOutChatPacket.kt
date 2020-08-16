package eu.feather.featherengine.network.packets.play.client

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.writeStringUtf8

data class PlayOutChatPacket(
    val message: String,
    val position: Byte
) {
    companion object : PacketParser<PlayOutChatPacket> {

        override suspend fun ByteWriteChannel.write(t: PlayOutChatPacket) {
            writeStringUtf8(t.message)
            writeByte(t.position)
        }

        override suspend fun ByteReadChannel.read(): PlayOutChatPacket {
            TODO("Client bound packet")
        }

    }
}