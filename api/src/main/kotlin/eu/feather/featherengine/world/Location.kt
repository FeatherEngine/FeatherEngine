package eu.feather.featherengine.world

import eu.feather.featherengine.exceptions.DifferentWorldsException
import kotlin.math.pow
import kotlin.math.sqrt

data class Location(
    var world: World,
    var x: Double,
    var y: Double,
    var z: Double,
    var pitch: Float = 0F,
    var yaw: Float = 0F
) {

    fun distanceFlatSquared(location: Location): Double {
        if (world != location.world) {
            throw DifferentWorldsException("Locations are in two different worlds")
        }
        return (x - location.x).pow(2) + (z - location.z).pow(2)
    }

    fun distanceSquared(location: Location): Double {
        if (world != location.world) {
            throw DifferentWorldsException("Locations are in two different worlds")
        }
        return distanceFlat(location).pow(2) + (y - location.y).pow(2)
    }

    fun distanceFlat(location: Location): Double {
        return sqrt(distanceFlatSquared(location))
    }

    fun distance(location: Location): Double {
        return sqrt(distanceSquared(location))
    }

}