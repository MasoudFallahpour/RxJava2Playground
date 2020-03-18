package ir.fallahpoor.rxjava2playground.operators

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit

fun main() {

    // Generates letter 'A' to 'J'
    val observable1 = Observable
        .range(0, 10)
        .map {
            ('A'.toInt() + it).toChar().toString()
        }

    // Generates numbers 1 to 7 as strings
    val observable2 = Observable
        .range(1, 7)
        .map { n: Int ->
            n.toString()
        }
    /*
     * zip() combines the emissions of multiple Observables together via a specified function
     * and emits single items for each combination based on the results of this function.
     * zip() will only emit as many items as the number of items emitted by the source Observable
     * that emits the fewest items.
     */

    val zippedObservable =
        Observable.zip(
            observable1,
            observable2,
            BiFunction<String, String, Pair<String, String>> { t1, t2 -> Pair(t1, t2) })

    zippedObservable.subscribe { pair: Pair<String, String> ->
        println(pair)
    }

    TimeUnit.SECONDS.sleep(4)

}