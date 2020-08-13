package eu.feather.featherengine.world

interface Localizable {

    val location: Location;

    fun getWorld(): World {
        return location.world
    }

}