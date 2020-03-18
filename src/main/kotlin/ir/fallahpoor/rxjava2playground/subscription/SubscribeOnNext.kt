package ir.fallahpoor.rxjava2playground.subscription

import io.reactivex.Observable
import ir.fallahpoor.rxjava2playground.Logger
import ir.fallahpoor.rxjava2playground.creation.CreateObservable

class SubscribeOnNext {

    fun subscribe() {

        val observable: Observable<Int> = CreateObservable().create()
        /*
         * The return value of subscribe() is a Disposable reference with which we can stop
         * receiving items before the observable has finished sending them.
         */
        observable.subscribe { item: Int ->
            Logger.logMessage("onNext: $item")
        }

    }

}