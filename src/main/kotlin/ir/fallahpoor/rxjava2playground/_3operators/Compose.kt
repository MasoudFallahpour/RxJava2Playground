package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.functions.BiFunction
import ir.fallahpoor.rxjava2playground.Logger

fun main() {

    // Suppose we want to write a custom operator say odd(). odd() returns an Observable
    // that emits odd-indexed items of source Observable.

    // First solution is as follows. This works but it's no good. The reason is
    // it breaks operator chaining.
    val trueFalseObservable = Observable.just(true, false).repeat()
    val intObservable = Observable.range(1, 20)
    val oddObservable =
        intObservable.zipWith(trueFalseObservable, BiFunction { i: Int, b: Boolean -> Pair(i, b) })
            .filter {
                it.second
            }
            .map {
                it.first
            }
//    oddObservable.subscribe {
//        Logger.logMessage(it.toString())
//    }

    // A better way is to use compose() operator and pass it an instance of ObservableTransformer.
    // This way we don't break the chain!

    intObservable
        .compose(takeOddIndexItems())
        .subscribe {
            Logger.logMessage(it.toString())
        }

}

private fun <T> takeOddIndexItems(): ObservableTransformer<T, T> {

    return ObservableTransformer { inputObservable: Observable<T> ->

        val trueFalseObservable = Observable.just(true, false).repeat()

        val outputObservable =
            inputObservable.zipWith(trueFalseObservable, BiFunction { i: T, b: Boolean -> Pair(i, b) })
                .filter { pair: Pair<T, Boolean> ->
                    pair.second
                }
                .map { pair: Pair<T, Boolean> ->
                    pair.first
                }

        outputObservable

    }

}