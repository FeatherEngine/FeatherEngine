package eu.feather.featherengine.network.packets.play.client

import eu.feather.featherengine.network.packets.parser.PacketWriter
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.writeStringUtf8

data class PlayOutChatPacket(
    val message: String,
    val position: Byte
) {
    companion object : PacketWriter<PlayOutChatPacket> {

        override suspend fun ByteWriteChannel.write(t: PlayOutChatPacket) {
            writeStringUtf8(t.message)
            writeByte(t.position)
        }

    }
}