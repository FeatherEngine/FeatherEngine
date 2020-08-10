package eu.feather.featherengine.entity

import eu.feather.featherengine.Location
import eu.feather.featherengine.World
import eu.feather.featherengine.command.CommandSender

interface Entity : CommandSender {

    val location: Location
    var customName : String

    fun getWorld(): World {
        return location.world
    }

}