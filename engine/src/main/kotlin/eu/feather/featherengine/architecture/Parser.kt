package eu.feather.featherengine.architecture

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

suspend fun <T> ByteReadChannel.parse(parser: PacketParser<T>): T = parser.run { read() }

suspend fun <T> ByteWriteChannel.write(t: T, parser: PacketParser<T>): Unit = parser.run { write(t) }