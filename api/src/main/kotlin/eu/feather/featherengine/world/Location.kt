package eu.feather.featherengine.world

data class Location(
    var world: World,
    var x: Double,
    var y: Double,
    var z: Double,
    var pitch: Float = 0F,
    var yaw: Float = 0F
) {

}