package eu.feather.featherengine.network.packets.parser

import io.ktor.utils.io.ByteReadChannel

interface PacketReader<T> {

    suspend fun ByteReadChannel.read(): T

}