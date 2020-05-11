package ir.fallahpoor.rxjava2playground._4flowcontrol

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit
import kotlin.random.Random

fun main() {

    /*
     * When upstream Observable emits an item debounce(t) forwards it downstream if
     * and only if t units of time passes without upstream Observable emitting any
     * new item(s).
     */

    val numbers = Observable.range(1, 20)
    val relativeDelays = Observable.range(1, 20)
        .map {
            1 + Random.nextLong(5)
        }
    val absoluteDelays = relativeDelays.scan { acc: Long, n: Long ->
        acc + n
    }
    val numberDelayPair = numbers.zipWith(absoluteDelays, BiFunction { n: Int, delay: Long ->
        Pair(n, delay)
    })
    val delayedNumbers = numberDelayPair.flatMap { pair: Pair<Int, Long> ->
        val (number: Int, delay: Long) = pair
        Observable.just(number)
            .delay(delay, TimeUnit.SECONDS)
    }

    delayedNumbers
        .debounce(3, TimeUnit.SECONDS)
        .blockingSubscribe {
            println(it.toString())
        }
}