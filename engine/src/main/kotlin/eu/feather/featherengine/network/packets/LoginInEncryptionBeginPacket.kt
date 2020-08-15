package eu.feather.featherengine.network.packets

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel
import java.security.PublicKey
import javax.crypto.SecretKey

data class LoginInEncryptionBeginPacket(
    val secretKey: SecretKey,
    val publicKey: PublicKey,
    val verifyToken: ByteArray
) {
    companion object : PacketParser<LoginInEncryptionBeginPacket> {

        override suspend fun ByteWriteChannel.write(t: LoginInEncryptionBeginPacket) {}

        override suspend fun ByteReadChannel.read(): LoginInEncryptionBeginPacket {
            TODO("Not yet implemented")
        }

    }
}