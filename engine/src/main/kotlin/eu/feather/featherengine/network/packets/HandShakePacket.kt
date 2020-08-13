package eu.feather.featherengine.network.packets

import eu.feather.featherengine.annotations.PacketParser
import eu.feather.featherengine.annotations.VarInt


@PacketParser
data class HandShakePacket(
    @VarInt
    val protocolVersion: Int
)