package eu.feather.featherengine.network.packets.handshake

import eu.feather.featherengine.network.packets.parser.PacketParser
import eu.feather.featherengine.network.readString
import eu.feather.featherengine.network.readVarInt
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

data class HandshakePacket(
    val protocolVersion: Int,
    val serverAddress: String,
    val serverPort: Short,
    val nextState: ProtocolState
) {
    companion object : PacketParser<HandshakePacket> {

        override suspend fun ByteWriteChannel.write(t: HandshakePacket) {
            TODO("Server bound packet")
        }

        override suspend fun ByteReadChannel.read() =
            HandshakePacket(
                protocolVersion = readVarInt(),
                serverAddress = readString(),
                serverPort = readShort(),
                nextState = convertNextState(
                    readVarInt()
                )
            )

        private fun convertNextState(int: Int): ProtocolState {
            return when (int) {
                1 -> ProtocolState.STATUS
                2 -> ProtocolState.LOGIN
                else -> {
                    ProtocolState.UNKNOWN
                }
            }
        }

    }

    enum class ProtocolState {
        STATUS,
        LOGIN,
        UNKNOWN
    }

}