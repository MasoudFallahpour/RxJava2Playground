package ir.fallahpoor.rxjava2playground.operators

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ir.fallahpoor.rxjava2playground.Logger
import java.util.concurrent.TimeUnit

fun main() {

    /*
     * We can use subscribeOn() operator to specify the thread to be used for executing
     * the code above the subscribeOn() call.
     *
     * Suppose that we are creating an Observable using Observable.create().
     * Inside create() we are doing some synchronous network call to get the
     * next item to emit (By synchronous I mean no new thread is spawned to do
     * the network call.)
     * If we don't apply subscribeOn() on this Observable then that network call
     * would block the current thread and that's not good.
     * But if we use subscribeOn() and specify a Scheduler like Schedulers.io()
     * then that network call runs on a background thread and everything goes
     * well.
     *
     * NOTES:
     * - If subscribeOn() is applied multiple times then the one closest to the
     *   original Observable wins and others are discarded.
     * - The place where you apply subscribeOn() is irrelevant. It could be the
     *   very first operator in a chain of operators or the last one just before
     *   subscribe().
     */

    /////////////// Synchronous execution ///////////////

//    Logger.logMessage("Start")
//    val observable: Observable<String> = synchronousObservable()
//    Logger.logMessage("Created")
//    val observable1 = observable.map {
//        "X$it"
//    }
//    Logger.logMessage("Transformed")
//    observable1.subscribe(
//        {
//            Logger.logMessage("onNext: $it")
//        },
//        {
//            it?.message?.let { message ->
//                Logger.logMessage(message)
//            }
//        },
//        {
//            Logger.logMessage("onComplete")
//        }
//    )
//    Logger.logMessage("End")

    /////////////// Asynchronous execution ///////////////

    Logger.logMessage("Start")
    val observable: Observable<String> = synchronousObservable()
    Logger.logMessage("Created")
    val observable1 = observable.map {
        "X$it"
    }
    Logger.logMessage("Transformed")
    observable1
        .subscribeOn(Schedulers.io())
        .subscribe(
            {
                Logger.logMessage("onNext: $it")
            },
            {
                it?.message?.let { message ->
                    Logger.logMessage(message)
                }
            },
            {
                Logger.logMessage("onComplete")
            }
        )
    Logger.logMessage("End")

    TimeUnit.SECONDS.sleep(5)

}

/*
 * The following function returns an Observable that produces its items
 * synchronously. That means it uses the current thread to produce its
 * items and if producing an item takes long then current thread gets
 * blocked.
 */
private fun synchronousObservable(): Observable<String> =
    Observable.create {
        Logger.logMessage("Subscribed")
        it.onNext(produceItem("A"))
        it.onNext(produceItem("B"))
        it.onComplete()
    }

private fun produceItem(item: String): String {
    TimeUnit.SECONDS.sleep(1)
    return item
}