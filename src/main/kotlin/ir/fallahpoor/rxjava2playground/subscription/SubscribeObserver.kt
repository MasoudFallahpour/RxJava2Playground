package ir.fallahpoor.rxjava2playground.subscription

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import ir.fallahpoor.rxjava2playground.Logger
import ir.fallahpoor.rxjava2playground.creation.CreateObservable

class SubscribeObserver {

    fun subscribe() {

        val observable: Observable<Int> = CreateObservable().create()
        observable.subscribe(object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {
                Logger.logMessage("onSubscribe")
            }

            override fun onNext(item: Int) {
                Logger.logMessage("onNext: $item")
            }

            override fun onComplete() {
                Logger.logMessage("onComplete")
            }

            override fun onError(t: Throwable) {
                Logger.logMessage("onError: " + t.message)
            }

        })

    }

}