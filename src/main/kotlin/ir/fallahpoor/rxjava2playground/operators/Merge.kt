package ir.fallahpoor.rxjava2playground.operators

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {

    val observable1 = Observable
        .interval(500, TimeUnit.MILLISECONDS)
        .take(12)
        .map { "A $it" }
    val observable2 = Observable
        .interval(300, TimeUnit.MILLISECONDS)
        .take(5)
        .map { "B $it" }

    // merge() combines two or more Observables into one by merging their emissions.
    // It may interleave the items emitted by the merged Observables.
    // an onError notification from any of the source Observables will immediately
    // be passed through to observers and will terminate the merged Observable.

    val mergedObservable = Observable.merge(observable1, observable2)
    mergedObservable.subscribe {
        println(it)
    }

    TimeUnit.SECONDS.sleep(8)

}