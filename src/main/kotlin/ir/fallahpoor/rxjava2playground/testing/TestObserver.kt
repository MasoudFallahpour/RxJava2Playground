package ir.fallahpoor.rxjava2playground.testing

import io.reactivex.observers.TestObserver
import ir.fallahpoor.rxjava2playground.creation.RangeObservable

fun main() {

    /*
     * Using an instance of TestObserver we can assert about various aspects of an Observable
     * like assertNoError, assertValue, assertComplete, assertSubscribed etc.
     */

    val testObserver = TestObserver<Int>()

    RangeObservable()
        .create(1, 5)
        .subscribe(testObserver)

    testObserver.assertValues(1, 2, 3, 4, 5)
    testObserver.assertComplete()

}