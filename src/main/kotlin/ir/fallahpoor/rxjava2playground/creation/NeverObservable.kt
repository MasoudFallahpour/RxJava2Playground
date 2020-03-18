package ir.fallahpoor.rxjava2playground.creation

import io.reactivex.Observable

class NeverObservable {

    /*
     * Such Observable never emits any notifications, neither values nor completion or error.
     * This stream is useful for testing purposes.
     */
    fun create(): Observable<Int> = Observable.never()

}