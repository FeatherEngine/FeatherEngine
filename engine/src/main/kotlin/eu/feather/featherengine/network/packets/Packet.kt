package eu.feather.featherengine.network.packets

interface Packet {

    interface Response : Packet

    fun toByteArray() : ByteArray

    fun parse(bytes: ByteArray)

    fun respond(response: Response)

}