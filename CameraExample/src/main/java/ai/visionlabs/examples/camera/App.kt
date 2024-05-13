package ai.visionlabs.examples.camera

import android.app.Application
import ru.visionlabs.sdk.lunacore.LunaConfig
import ru.visionlabs.sdk.lunacore.LunaID
import ru.visionlabs.sdk.lunacore.liveness.GlassesCheckType
import ru.visionlabs.sdk.lunacore.liveness.LivenessType

class App : Application() {

    companion object {
        val lunaConfig = LunaConfig.create(
            acceptOccludedFaces = false,
            acceptOneEyed = true,
            foundFaceDelay = 700L,
            skipFrames = 50,
            interactionDelayMs = 200L,
            livenessType = LivenessType.None,
            bestShotsCount = 10,
            acceptEyesClosed = false,
            glassesChecks = setOf(GlassesCheckType.GLASSES_CHECK_SUN),
            ags = 0.3F,
        )
    }

    override fun onCreate() {
        super.onCreate()
        LunaID.activateLicense(this, lunaConfig)
    }
}