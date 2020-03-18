package ir.fallahpoor.rxjava2playground.flowcontrol

import io.reactivex.Observable

fun main() {

    /*
     * window() operator is pretty much like buffer() with one difference.
     * Where buffer() converts the source Observable<T> to Observable<List<T>>,
     * window() converts the source Observable<T> into Observable<Observable<T>.
     * So instead of emitting a List<T>, window() emits an Observable<T> downstream.
     */

    val o: Observable<Observable<Int>> = Observable
        .range(1, 10)
        .window(3)

    o.subscribe { inner: Observable<Int> ->
        inner.subscribe { i: Int ->
            println(i)
        }
        println("#################")
    }

}