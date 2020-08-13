package eu.feather.featherengine.network.packets.parser

import io.ktor.utils.io.ByteReadChannel

interface PacketParser<T> {

    fun toByteArray(t: T): ByteArray

    fun parse(byteChannel: ByteReadChannel): T

}