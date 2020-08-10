package eu.feather.featherengine.entity

import eu.feather.featherengine.GameMode
import eu.feather.featherengine.OfflinePlayer

interface Player : LivingEntity, OfflinePlayer {

    var displayName: String
    var gameMode: GameMode

}