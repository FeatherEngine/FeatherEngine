package eu.feather.featherengine.architecture

import eu.feather.featherengine.network.packets.parser.PacketParser
import io.ktor.utils.io.ByteReadChannel

suspend fun <T> ByteReadChannel.parse(parser: PacketParser<T>): T = parser.run { read() }