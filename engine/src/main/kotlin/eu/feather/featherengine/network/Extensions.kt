package eu.feather.featherengine.network

import io.ktor.utils.io.ByteReadChannel
import kotlin.experimental.and

suspend fun ByteReadChannel.readVarInt(): Int {
    var numRead = 0
    var result = 0
    var read: Byte
    do {
        read = readByte()
        val value = (read and 127).toInt()
        result = result or (value shl 7 * numRead)
        numRead++
        if (numRead > 5) {
            throw RuntimeException("VarInt is too big")
        }
    } while (read and 128.toByte() != 0.toByte())
    return result
}

suspend fun ByteReadChannel.readString(): String {
    val length = readVarInt()
    return readUTF8Line(length) ?: throw RuntimeException("chuj wie co się stało")
}