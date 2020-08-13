package eu.feather.featherengine.entity

interface Damageable {

    var maxHealth: Double
    var health: Double

    fun damage(amount: Double)

}