package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {

    /*
     * delay() returns an Observable that emits the items emitted by the original Observable shifted
     * forward in time by a specified delay.
     */

    Observable
        .just(
            "Lorem", "ipsum", "dolor", "sit", "amet",
            "consectetur", "adipiscing", "elit"
        )
        .delay { word ->
            Observable.timer(word.length.toLong(), TimeUnit.SECONDS)
        }
        .subscribe(System.out::println)

    TimeUnit.SECONDS.sleep(10)

}