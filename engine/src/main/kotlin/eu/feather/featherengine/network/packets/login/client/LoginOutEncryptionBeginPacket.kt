package eu.feather.featherengine.network.packets.login.client

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.writePacket
import io.ktor.utils.io.writeStringUtf8

data class LoginOutEncryptionBeginPacket(
    val serverId: String,
    val publicKeyLength: Int,
    val publicKey: ByteArray,
    val verifyTokenLength: Int,
    val verifyToken: ByteArray
) {
    companion object : PacketParser<LoginOutEncryptionBeginPacket> {

        override suspend fun ByteWriteChannel.write(t: LoginOutEncryptionBeginPacket) {
            writeStringUtf8(t.serverId)
            writeInt(t.publicKeyLength)
            writePacket {
                t.publicKey
            }
            writeInt(t.verifyTokenLength)
            writePacket {
                t.verifyToken
            }
        }

        override suspend fun ByteReadChannel.read(): LoginOutEncryptionBeginPacket {
            TODO("Client bound packet")
        }

    }
}