package eu.feather.featherengine.network.status.client

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.writeStringUtf8

data class StatusOutResponsePacket(
    val response: String
) {
    companion object : PacketParser<StatusOutResponsePacket> {

        override suspend fun ByteWriteChannel.write(t: StatusOutResponsePacket) {
            writeStringUtf8(t.response)
        }

        override suspend fun ByteReadChannel.read(): StatusOutResponsePacket {
            TODO("Client bound packet")
        }

    }
}