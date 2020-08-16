package eu.feather.featherengine.network.packets.parser

import io.ktor.utils.io.ByteWriteChannel

interface PacketWriter<T> {

    suspend fun ByteWriteChannel.write(t: T)

}