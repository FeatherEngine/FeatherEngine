package eu.feather.featherengine.network.packets.login.server

import eu.feather.featherengine.network.packets.parser.PacketParser
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
    companion object : PacketParser<LoginInEncryptionBeginPacket> {

        override suspend fun ByteWriteChannel.write(t: LoginInEncryptionBeginPacket) {
            TODO("Server bound packet")
        }

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