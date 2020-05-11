package ir.fallahpoor.rxjava2playground._2subscription

import io.reactivex.Observable
import ir.fallahpoor.rxjava2playground.Logger
import ir.fallahpoor.rxjava2playground._1creation.CreateObservable

class SubscribeOnNextOnError {

    fun subscribe() {

        val observable: Observable<Int> = CreateObservable().create()
        observable.subscribe(
            { item: Int ->
                Logger.logMessage("onNext: $item")
            },
            { t: Throwable ->
                Logger.logMessage("onError: " + t.message)
            })

    }

}