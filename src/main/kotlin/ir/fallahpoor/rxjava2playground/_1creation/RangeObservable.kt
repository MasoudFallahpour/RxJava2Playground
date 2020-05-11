package ir.fallahpoor.rxjava2playground._1creation

import io.reactivex.Observable

class RangeObservable {

    /*
     * Produces 'count' integer numbers starting from 'start'. For example, range(5, 3) will
     * emit 5, 6, and 7 and then complete normally. Each subscriber will receive the same
     * set of numbers.
     */
    fun create(start: Int, count: Int): Observable<Int> = Observable.range(start, count)

}