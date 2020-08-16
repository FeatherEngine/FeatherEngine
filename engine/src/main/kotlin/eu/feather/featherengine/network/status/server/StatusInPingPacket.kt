package eu.feather.featherengine.network.status.server

import eu.feather.featherengine.network.packets.parser.PacketReader
import eu.feather.featherengine.network.packets.parser.PacketWriter
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

data class StatusInPingPacket(
    val payload: Long
) {
    companion object : PacketReader<StatusInPingPacket> {

        override suspend fun ByteReadChannel.read() =
            StatusInPingPacket(
                payload = readLong()
            )

    }
}