package eu.feather.featherengine.network.packets.login.server

import eu.feather.featherengine.network.packets.parser.PacketReader
import eu.feather.featherengine.network.packets.parser.PacketWriter
import eu.feather.featherengine.network.readVarInt
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.core.readBytes
import io.ktor.utils.io.readPacket

data class LoginInEncryptionBeginPacket(
    val secretKeyLength: Int,
    val secretKey: ByteArray,
    val verifyTokenLength: Int,
    val verifyToken: ByteArray
) {
    companion object : PacketReader<LoginInEncryptionBeginPacket> {

        override suspend fun ByteReadChannel.read(): LoginInEncryptionBeginPacket {
            val secretKeyLength = readVarInt()
            val secretKey = readPacket(secretKeyLength).readBytes()
            val verifyTokenLength = readVarInt()
            val verifyToken = readPacket(verifyTokenLength).readBytes()
            return LoginInEncryptionBeginPacket(
                secretKeyLength = secretKeyLength,
                secretKey = secretKey,
                verifyTokenLength = verifyTokenLength,
                verifyToken = verifyToken
            )
        }

    }
}