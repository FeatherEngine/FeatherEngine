package eu.feather.featherengine

import eu.feather.featherengine.entity.Player
import java.util.*

interface OfflinePlayer {

    val uuid: UUID
    val online: Boolean

    fun getPlayer(): Player?

}