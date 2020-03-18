package ir.fallahpoor.rxjava2playground.flowcontrol

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {

    /*
     * sample() operator, in each time window, emits the last value emitted by upstream
     * Observable in that time window.
     * throttleLast() is an alis for sample().
     */

    // Upstream Observable  -----0----1---2---------3--4----5-----6--7---------8-------9
    // Sampling Period      -----|-----|-----|-----|-----|-----|-----|-----|-----|-----|
    // sample/throttleLast  -----------1-----2-----------4-----5-----6-----7-----8------

    Observable
        .interval(2, TimeUnit.SECONDS)
        .take(5)
        .doOnNext {
            println("@@@ $it")
        }
        .sample(4, TimeUnit.SECONDS)
//        .throttleLatest(4, TimeUnit.SECONDS)
        .blockingSubscribe {
            println("$$$ $it")
        }

}