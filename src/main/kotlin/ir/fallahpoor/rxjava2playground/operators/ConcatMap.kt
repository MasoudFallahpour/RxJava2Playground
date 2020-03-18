package ir.fallahpoor.rxjava2playground.operators

import io.reactivex.Observable
import ir.fallahpoor.rxjava2playground.creation.RangeObservable
import java.util.concurrent.TimeUnit

fun main() {

    /*
     * concatMap() works almost the same as flatMap(), but preserves the order of items
     * emitted by sub-Observables.
     */

    println("[FlatMap]")

    RangeObservable()
        .create(1, 15)
        .flatMap { n: Int ->
            Observable.just(n).delay(1, TimeUnit.MILLISECONDS)
        }
        .subscribe { n: Int ->
            print("$n ")
        }

    TimeUnit.MILLISECONDS.sleep(100)
    println()

    println("[ConcatMap]")

    RangeObservable()
        .create(1, 15)
        .concatMap { n: Int ->
            Observable.just(n).delay(1, TimeUnit.MILLISECONDS)
        }
        .subscribe { n: Int ->
            print("$n ")
        }

    TimeUnit.MILLISECONDS.sleep(100)

}