package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable
import ir.fallahpoor.rxjava2playground.Logger
import kotlin.random.Random

fun main() {

    /*
     * distinct() operator discards events from upstream Observable that
     * already occurred, making sure only unique events are passed downstream.
     * Bear in mind that distinct() must keep track of all events seen so far
     * for eternity to decide whether an event is duplicated or not.
     */

    // Generates 50 random numbers in range [0, 50) (some numbers may be duplicated)
    val randomNumbers = Observable.create<Int> {
        for (i in 1..50) {
            it.onNext(Random.nextInt(0, 50))
        }
    }

    // Removes duplication form those 50 random numbers
    val uniqueRandomNumbers = randomNumbers.distinct()

    uniqueRandomNumbers.subscribe {
        Logger.logMessage(it.toString())
    }

}