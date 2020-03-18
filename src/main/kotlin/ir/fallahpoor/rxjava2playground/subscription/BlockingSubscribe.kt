package ir.fallahpoor.rxjava2playground.subscription

import io.reactivex.Observable
import ir.fallahpoor.rxjava2playground.Logger
import java.util.concurrent.TimeUnit

fun main() {

    /*
     * blockingSubscribe() subscribes to the Observable and blocks the current thread
     * until the Observable either completes or encounters an error.
     */

    val observable = Observable
        .interval(1, TimeUnit.SECONDS)
        .take(10)

//    Logger.logMessage("Before subscribe")
//    observable
//        .subscribe {
//            Logger.logMessage("$it ")
//        }
//    Logger.logMessage("After subscribe")

    Logger.logMessage("Before blocking subscribe")
    observable.blockingSubscribe {
        Logger.logMessage("$it ")
    }
    // The following line does not execute until the above observable completes
    Logger.logMessage("After blocking subscribe")

}