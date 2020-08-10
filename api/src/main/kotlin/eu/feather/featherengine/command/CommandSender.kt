package eu.feather.featherengine.command

import com.sun.xml.internal.fastinfoset.util.StringArray

interface CommandSender {

    val name: String

    fun sendMessage(message: String)

    fun sendMessage(message: StringArray)

}