package eu.feather.featherengine.entity

import eu.feather.featherengine.command.CommandSender
import eu.feather.featherengine.world.Localizable
import java.util.*

interface Entity : CommandSender, Localizable {

    val uuid: UUID

    var customName: String

}