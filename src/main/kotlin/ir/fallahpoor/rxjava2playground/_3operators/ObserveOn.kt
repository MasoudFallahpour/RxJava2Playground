package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ir.fallahpoor.rxjava2playground.Logger

fun main() {

    /*
     * We can use observeOn() operator to specify the thread to be used for executing
     * the code below the observeOn() call.
     *
     * NOTES:
     * - observeOn() could be called multiple times and each call changes the thread
     *   to be used for executing the code below it.
     * - The place you apply observeOn() matters. If you apply it in middle of a chain
     *   of other operators then operators that are below observeOn() are executed
     *   on the thread specified by observerOn() and operators above observeOn() are
     *   executed on (possibly) another thread.
     */

    Logger.logMessage("Start")
    val observable: Observable<String> = synchronousObservable()
    Logger.logMessage("Created")
    observable
        .doOnNext {
            Logger.logMessage("doOnNext1: $it")
        }
        .observeOn(Schedulers.io())
        .doOnNext {
            Logger.logMessage("doOnNext2: $it")
        }
        .subscribe {
            Logger.logMessage("onNext: $it")
        }
    Logger.logMessage("End")

}

private fun synchronousObservable(): Observable<String> =
    Observable.create {
        Logger.logMessage("Subscribed")
        it.onNext(produceItem("A"))
        it.onNext(produceItem("B"))
        it.onComplete()
    }

private fun produceItem(item: String): String {
    return item
}