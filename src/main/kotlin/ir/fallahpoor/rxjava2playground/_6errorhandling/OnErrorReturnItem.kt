package ir.fallahpoor.rxjava2playground._6errorhandling

import io.reactivex.Observable

fun main() {

    /*
     * onErrorReturnItem() watches for any error event from upstream Observable and
     * if that happens, instead of forwarding it downstream, it forwards the given value.
     * When using onErrorReturnItem there is no need for an error callback when subscribing
     * to the Observable because we are sure the Observable does not emit any error item.
     */

    val observable = Observable.create<Int> {
        it.onNext(100)
        it.onNext(200)
        it.onNext(300)
        it.onNext(400)
        throw Throwable("Oops ...")
    }

    observable
        .onErrorReturnItem(1000)
        .subscribe {
            println(it)
        }

}