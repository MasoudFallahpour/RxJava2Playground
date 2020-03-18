package ir.fallahpoor.rxjava2playground.subscription

import io.reactivex.Observable
import ir.fallahpoor.rxjava2playground.creation.CreateObservable

class Subscribe {

    fun subscribe() {
        val observable: Observable<Int> = CreateObservable().create()
        observable.subscribe()
    }

}