package eu.feather.featherengine.network.status.server

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

data class StatusInPingPacket(
    val payload: Long
) {
    companion object : PacketParser<StatusInPingPacket> {

        override suspend fun ByteWriteChannel.write(t: StatusInPingPacket) {
            TODO("Server bound packet")
        }

        override suspend fun ByteReadChannel.read() =
            StatusInPingPacket(
                payload = readLong()
            )

    }
}