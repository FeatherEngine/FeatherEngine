package eu.feather.featherengine.architecture

import eu.feather.featherengine.network.packets.parser.PacketReader
import eu.feather.featherengine.network.packets.parser.PacketWriter
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.ByteWriteChannel

suspend fun <T> ByteReadChannel.parse(parser: PacketReader<T>): T = parser.run { read() }

suspend fun <T> ByteWriteChannel.write(t: T, parser: PacketWriter<T>): Unit = parser.run { write(t) }