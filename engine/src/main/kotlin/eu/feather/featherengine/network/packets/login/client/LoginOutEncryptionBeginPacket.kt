package eu.feather.featherengine.network.packets.login.client

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
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
            //Send public key here
            writeInt(t.verifyTokenLength)
            //Send verify token here
        }

        override suspend fun ByteReadChannel.read(): LoginOutEncryptionBeginPacket {
            TODO("Client bound packet")
        }

    }
}