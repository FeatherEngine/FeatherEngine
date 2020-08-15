package eu.feather.featherengine.network.packets

import eu.feather.featherengine.network.packets.parser.PacketParser
import eu.feather.featherengine.network.readVarInt
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

data class HandShakePacket(
    val protocolVersion: Int,
    val serverAddress: String,
    val serverPort: Short,
    val nextState: ProtocolState
) {
    companion object : PacketParser<HandShakePacket> {

        override suspend fun ByteWriteChannel.write(t: HandShakePacket) { }

        override suspend fun ByteReadChannel.read() = HandShakePacket(
            protocolVersion = readVarInt(),
            serverAddress = "",
            serverPort = 13333,
            nextState = ProtocolState.LOGIN
        )

    }

    enum class ProtocolState {
        STATUS,
        LOGIN
    }

}