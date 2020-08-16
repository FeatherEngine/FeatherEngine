package eu.feather.featherengine.network.status.server

import eu.feather.featherengine.network.packets.parser.PacketReader
import eu.feather.featherengine.network.packets.parser.PacketWriter
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

class StatusInRequestPacket() { //NO FIELDS
    companion object : PacketReader<StatusInRequestPacket> {

        override suspend fun ByteReadChannel.read() =
            StatusInRequestPacket()

    }
}