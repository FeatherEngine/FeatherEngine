package eu.feather.featherengine

import kotlin.math.floor

data class Location(
    var world: World,
    var x: Double,
    var y: Double,
    var z: Double,
    var pitch: Float = 0F,
    var yaw: Float = 0F
) {

    fun center() {
        x = floor(x) + 0.5
        y = floor(y) + 0.5
        z = floor(z) + 0.5
    }

}