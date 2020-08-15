package eu.feather.featherengine.network.packets.parser

import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

interface PacketParser<T> {

    suspend fun ByteWriteChannel.write(t: T)

    suspend fun ByteReadChannel.read(): T

}