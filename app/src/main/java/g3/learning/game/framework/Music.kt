package g3.learning.game.framework

interface Music {
    fun play()

    fun stop()

    fun pause()

    fun setLooping(looping: Boolean)

    fun setVolume(volume: Float)

    fun isPlaying(): Boolean

    fun isStopped(): Boolean

    fun isLooping(): Boolean

    fun dispose()
}