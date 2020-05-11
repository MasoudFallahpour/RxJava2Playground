package ir.fallahpoor.rxjava2playground._4flowcontrol

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {

    /*
     * throttleFirst() is like sample() but instead of emitting the last value of upstream
     * Observable in a given time window, it emits the first value in that time window.
     */

    // Upstream Observable  -----0----1---2---------3--4----5-----6--7---------8-------9
    // Sampling Period      -----|-----|-----|-----|-----|-----|-----|-----|-----|-----|
    // throttleFirst        -----------0-----2-----------3-----5-----6-----7-----8------

    Observable
        .interval(2, TimeUnit.SECONDS)
        .take(5)
        .doOnNext {
            println("@@@ $it")
        }
        .throttleFirst(4, TimeUnit.SECONDS)
        .blockingSubscribe {
            println("$$$ $it")
        }

}