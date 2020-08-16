package eu.feather.featherengine.network.status.client

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

data class StatusOutPongPacket(
    val payload: Long
) {
    companion object : PacketParser<StatusOutPongPacket> {

        override suspend fun ByteWriteChannel.write(t: StatusOutPongPacket) {
            writeLong(t.payload)
        }

        override suspend fun ByteReadChannel.read(): StatusOutPongPacket {
            TODO("Client bound packet")
        }

    }
}