package ir.fallahpoor.rxjava2playground.operators

import io.reactivex.Observable

fun main() {

    /*
     * filter(predicate) filters items emitted by an Observable by only emitting
     * those that satisfy the specified predicate.
     */

    val numbersObservable = Observable.create<Int> {
        for (i in 1..25) {
            it.onNext(i)
        }
    }

    val evenNumbersObservable = numbersObservable.filter {
        it % 2 == 0
    }

    evenNumbersObservable.subscribe {
        println(it)
    }

}