package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable
import ir.fallahpoor.rxjava2playground._1creation.RangeObservable

fun main() {

    /*
     * concat() concatenates the output of multiple Observables so that they act like a single
     * Observable, with all of the items emitted by the first Observable being emitted before
     * any of the items emitted by the second Observable (and so forth, if there are more than two).
     * Keep in mind that concat() will subscribe to the next Observable if, and only if,
     * the previous one is completed.
     */

    Observable.concat(
        RangeObservable().create(1, 10),
        RangeObservable().create(11, 10)
    ).subscribe {
        print("$it ")
    }

}