package ir.fallahpoor.rxjava2playground._2subscription

import io.reactivex.Observable
import ir.fallahpoor.rxjava2playground._1creation.CreateObservable

class Subscribe {

    fun subscribe() {
        val observable: Observable<Int> = CreateObservable().create()
        observable.subscribe()
    }

}