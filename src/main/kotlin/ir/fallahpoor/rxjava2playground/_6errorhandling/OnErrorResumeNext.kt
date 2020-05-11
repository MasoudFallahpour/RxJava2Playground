package ir.fallahpoor.rxjava2playground._6errorhandling

import io.reactivex.Observable

fun main() {

    /*
     * onErrorResumeNext() watches for any error event from upstream Observable and
     * if that happens, instead of forwarding it downstream, it subscribes to given
     * Observable.
     */

    val observable = Observable.create<Int> {
        it.onNext(100)
        it.onNext(200)
        it.onNext(300)
        it.onNext(400)
        throw Throwable("Oops ...")
    }
    val fallbackObservable = Observable.create<Int> {
        it.onNext(500)
        it.onNext(600)
        it.onNext(700)
        it.onNext(800)
        it.onComplete()
    }

    observable
        .onErrorResumeNext(fallbackObservable)
        .subscribe(
            {
                println("onNext: $it")
            },
            {
                println(it.message)
            },
            {
                println("OnComplete")
            }
        )

}