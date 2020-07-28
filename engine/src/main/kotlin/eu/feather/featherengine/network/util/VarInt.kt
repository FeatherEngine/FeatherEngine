package eu.feather.featherengine.network.util

import eu.feather.featherengine.network.readVarInt
import io.ktor.utils.io.ByteReadChannel

class VarInt {
    var value = 0
        private set

    suspend fun parse(channel: ByteReadChannel) {
        value = channel.readVarInt()
    }
}