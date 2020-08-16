package eu.feather.featherengine.network.status.client

import eu.feather.featherengine.network.packets.parser.PacketWriter
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

data class StatusOutPongPacket(
    val payload: Long
) {
    companion object : PacketWriter<StatusOutPongPacket> {

        override suspend fun ByteWriteChannel.write(t: StatusOutPongPacket) {
            writeLong(t.payload)
        }

    }
}