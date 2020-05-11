package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable
import io.reactivex.ObservableOperator
import io.reactivex.functions.Action
import io.reactivex.observers.DisposableObserver

fun main() {

    Observable.empty<Int>()
        .lift(doOnEmpty(Action { println("Damn! the Observable emitted nothing.") }))
        .subscribe {
            println("onNext: $it")
        }

    Observable.range(1, 5)
        .lift(doOnEmpty(Action { println("Damn! the Observable emitted nothing.") }))
        .subscribe {
            println("onNext: $it")
        }

}

/*
 * This is a custom operator that runs the provided action if the upstream Observable
 * completes without emitting any event.
 *
 * Taken from https://mouaad.aallam.com/rxjava-custom-operators/
 */
fun <T> doOnEmpty(action: Action): ObservableOperator<T, T> {

    return ObservableOperator { observer ->

        object : DisposableObserver<T>() {

            var emittedNothing = true

            override fun onComplete() {
                if (emittedNothing) {
                    try {
                        action.run()
                    } catch (e: Exception) {
                        onError(e)
                        return
                    }
                }
                observer.onComplete()
            }

            override fun onNext(t: T) {
                this.emittedNothing = false
                observer.onNext(t)
            }

            override fun onError(e: Throwable) {
                observer.onError(e)
            }

        } // end of DisposableObserver

    } // end of ObservableOperator

} // end of doOnEmpty