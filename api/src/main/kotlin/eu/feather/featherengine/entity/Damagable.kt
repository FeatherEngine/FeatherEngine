package eu.feather.featherengine.entity

interface Damagable {

    var maxHealth: Double
    var health: Double

    fun damage(amount: Double)

}