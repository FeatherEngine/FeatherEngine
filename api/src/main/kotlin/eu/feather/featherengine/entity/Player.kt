package eu.feather.featherengine.entity

import eu.feather.featherengine.GameMode

interface Player : LivingEntity {

    var displayName : String
    var gameMode : GameMode

}