package ir.fallahpoor.rxjava2playground._1creation

import io.reactivex.Observable

class CreateObservable {

    fun create(): Observable<Int> =
        Observable.create {
            for (i in 1..5) {
                it.onNext(i * i)
            }
            it.onComplete()
        }

}