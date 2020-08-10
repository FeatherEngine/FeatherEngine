package eu.feather.featherengine.entity

import eu.feather.featherengine.Location
import eu.feather.featherengine.World

interface Entity {

    fun getName() : String

    fun getLocation() : Location

    fun getWorld(): World {
        return getLocation().world
    }

}