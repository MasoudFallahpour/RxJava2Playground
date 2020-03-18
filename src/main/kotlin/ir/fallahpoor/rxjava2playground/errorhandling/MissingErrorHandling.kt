package ir.fallahpoor.rxjava2playground.errorhandling

import io.reactivex.Observable

fun main() {

    /*
     * The following Observable throws an Exception and when subscribing
     * we have not provided any callback for the case when there is an Exception.
     * So a crash is inevitable.
     * It's always good practice to watch for exceptions when subscribing to an
     * Observable.
     */

//    Observable.create<Int> {
//        try {
//            it.onNext(1 / 0)
//        } catch (e: Exception) {
//            it.onError(e)
//        }
//    }.subscribe {
//        Logger.logMessage(it.toString())
//    }

    Observable.create<Int> {
        try {
            it.onNext(1 / 0)
        } catch (e: Exception) {
            it.onError(e)
        }
    }.subscribe(
        {
            println(it)
        },
        { t: Throwable ->
            println(t.message)
        }
    )

}