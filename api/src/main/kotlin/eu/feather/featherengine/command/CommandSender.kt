package eu.feather.featherengine.command
interface CommandSender {

    val name: String

    fun sendMessage(message: String)

    fun sendMessage(message: Array<String>)

}