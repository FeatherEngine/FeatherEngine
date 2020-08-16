package eu.feather.featherengine.network.packets.play.server

import eu.feather.featherengine.network.packets.parser.PacketParser
import eu.feather.featherengine.network.readString
import eu.feather.featherengine.network.readVarInt
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

data class PlayInClientSettingsPacket(
    val locale: String,
    val viewDistance: Byte,
    val chatMode: Int,
    val chatColors: Boolean,
    val displayedSkinParts: Byte, //IT SHOULD BE UNSIGNED BYTE
    val mainHand: Int
) {
    companion object : PacketParser<PlayInClientSettingsPacket> {

        override suspend fun ByteWriteChannel.write(t: PlayInClientSettingsPacket) {
            TODO("Server bound packet")
        }

        override suspend fun ByteReadChannel.read() =
            PlayInClientSettingsPacket(
                locale = readString(),
                viewDistance = readByte(),
                chatMode = readVarInt(),
                chatColors = readBoolean(),
                displayedSkinParts = readByte(), //IT SHOULD BE UNSIGNED BYTE
                mainHand = readVarInt()
            )

    }
}