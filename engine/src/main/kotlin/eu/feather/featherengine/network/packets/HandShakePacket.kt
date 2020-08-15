package eu.feather.featherengine.network.packets

import eu.feather.featherengine.network.packets.parser.PacketParser
import eu.feather.featherengine.network.readVarInt
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

data class HandShakePacket(
    val protocolVersion: Int
) {
    companion object : PacketParser<HandShakePacket> {

        override suspend fun ByteWriteChannel.write(t: HandShakePacket) {
            writeInt(t.protocolVersion) // change to var int
        }

        override suspend fun ByteReadChannel.read() = HandShakePacket(
            protocolVersion = readVarInt()
        )

    }
}