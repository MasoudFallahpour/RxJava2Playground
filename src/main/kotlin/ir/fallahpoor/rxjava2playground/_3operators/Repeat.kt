package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable
import ir.fallahpoor.rxjava2playground.Logger

fun main() {

    /*
     * repeat() returns an Observable that repeats the sequence of items emitted by the source
     * Observable indefinitely.
     */
    val observable = Observable.just(true, false).repeat()

    observable
        .take(10)
        .subscribe {
            Logger.logMessage(it.toString())
        }

}