package ir.fallahpoor.rxjava2playground._1creation

import io.reactivex.Observable

class EmptyObservable {

    /*
     * Completes immediately after subscription, without emitting any values.
     */
    fun create(): Observable<Int> = Observable.empty()

}