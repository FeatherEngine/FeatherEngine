package eu.feather.featherengine.network.packets

data class ServerBoundPacket(
    val protocolVersion: Int
) : Packet {
    override fun toByteArray(): ByteArray {
        TODO("Not yet implemented")
    }

    override fun parse(bytes: ByteArray) {
        TODO("Not yet implemented")
    }

    override fun respond(response: Packet.Response) {
        TODO("Not yet implemented")
    }

}