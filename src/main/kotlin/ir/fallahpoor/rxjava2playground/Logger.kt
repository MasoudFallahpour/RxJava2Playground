package ir.fallahpoor.rxjava2playground

object Logger {

    fun logMessage(message: String) {
        println("[" + Thread.currentThread().name + "] " + message)
    }

}