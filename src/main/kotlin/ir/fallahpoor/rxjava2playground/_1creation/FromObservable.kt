package ir.fallahpoor.rxjava2playground._1creation

import io.reactivex.Observable

class FromObservable {

    /*
     * Similar to just() but accepts an array, thus creating Observable<T> with as
     * many values emitted as elements in values collection.
     */
    fun create(): Observable<Int> = Observable.fromArray(1, 2, 3, 4, 5, 6, 7)

}