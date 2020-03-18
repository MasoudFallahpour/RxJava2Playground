package ir.fallahpoor.rxjava2playground.flowcontrol

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {

    /*
     * buffer() operator batches some items of upstream Observable and emits each
     * batch as a list. It has different versions, some are size-based and some are
     * time-based.
     * Take for example buffer(N). It emits each N items of upstream Observable as a list.
     *
     * NOTE:
     * Because buffer() requires creating an intermediate List before the current buffer is
     * closed and passed downstream, it might unnecessarily put pressure on garbage collection
     * and memory usage.
     */

    Observable
        .range(1, 10)
        .buffer(3)
        .blockingSubscribe { list: List<Int> ->
            println(list)
        }

    println()

    Observable
        .range(1, 7)
        .buffer(3, 1)
        .blockingSubscribe { list: List<Int> ->
            println(list)
        }

    println()

    Observable
        .interval(1, TimeUnit.SECONDS)
        .take(20)
        .buffer(3, TimeUnit.SECONDS)
        .blockingSubscribe { list: List<Long> ->
            println(list)
        }

}