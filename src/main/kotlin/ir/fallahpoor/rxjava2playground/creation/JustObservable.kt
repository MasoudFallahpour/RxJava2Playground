package ir.fallahpoor.rxjava2playground.creation

import io.reactivex.Observable

class JustObservable {

    /*
     * Creates an Observable instance that emits exactly one value to all future subscribers
     * and completes afterward. Overloaded versions of the just() operator can take anything
     * from two to nine values to be emitted.
    */
    fun create(item: Int): Observable<Int> = Observable.just(item)

}