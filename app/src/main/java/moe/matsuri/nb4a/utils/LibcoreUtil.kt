package moe.matsuri.nb4a.utils

import io.nekohasekai.sagernet.database.DataStore
import io.nekohasekai.sagernet.database.ProfileManager
import io.nekohasekai.sagernet.database.ProxyEntity
import libcore.Libcore

object LibcoreUtil {
    fun resetAllConnections(system: Boolean) {
        if (DataStore.serviceState.started) {
            val proxy = ProfileManager.getProfile(DataStore.currentProfile)
            if (proxy?.type == ProxyEntity.TYPE_TUIC) {
                return
            }
        }
        Libcore.resetAllConnections(system)
    }
}
