package eu.feather.featherengine.network.status.server

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

class StatusInRequestPacket() { //NO FIELDS
    companion object : PacketParser<StatusInRequestPacket> {

        override suspend fun ByteWriteChannel.write(t: StatusInRequestPacket) {
            TODO("Server bound packet")
        }

        override suspend fun ByteReadChannel.read() =
            StatusInRequestPacket()

    }
}