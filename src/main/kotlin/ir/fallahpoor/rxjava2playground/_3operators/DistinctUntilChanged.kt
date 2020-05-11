package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable
import ir.fallahpoor.rxjava2playground.Logger

fun main() {

    /*
     * In the case of distinctUntilChanged() , any given event is discarded only if the
     * previous event was the same.
     * distinctUntilChanged() works best when we receive a steady stream of some measurements,
     * and we want to be notified only when the measured value is actually changed.
     */
    Observable.fromArray(1, 1, 3, 7, 4, 4, 1, 10, 5, 6, 7, 7, 9, 4)
        .distinctUntilChanged()
        .subscribe {
            Logger.logMessage(it.toString())
        }

}