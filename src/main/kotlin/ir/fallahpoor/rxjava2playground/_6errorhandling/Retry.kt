package ir.fallahpoor.rxjava2playground._6errorhandling

import io.reactivex.Observable

fun main() {

    /*
     * retry() resubscribes to the upstream Observable if the source Observable calls onError().
     * In other words, when the upstream Observable calls onError(), instead of propagating it
     * downstream, retry() swallows the error and resubscribes to the upstream Observable.
     *
     * NOTES:
     * - retry() keeps resubscribing until upstream Observable emits no error and completes successfully.
     * - If upstream Observable emits say for example 2 items and then fails, when resubscribing using
     *   retry(), those 2 items are emitted again and hence duplicate item(s) are inevitable when using
     *   retry().
     * - retry() has many variants including retry(N) where N is the maximum number of retries.
     */

//    riskyObservable()
//        .subscribe(
//            {
//                println("onNext: $it")
//            },
//            {
//                println(it.message)
//            },
//            {
//            }
//        )

    riskyObservable()
        .doOnError {
            println(it.message)
        }
        .retry()
        .subscribe {
            println("onNext: $it")
        }
}

private fun riskyObservable(): Observable<String> =
    Observable.fromCallable<String> {
        if (Math.random() < 0.1) {
            Thread.sleep((Math.random() * 2000).toLong())
            "OK"
        } else {
            throw RuntimeException("An error occurred")
        }
    }