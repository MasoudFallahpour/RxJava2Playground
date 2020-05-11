package ir.fallahpoor.rxjava2playground._7testing

import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import java.util.concurrent.TimeUnit

fun main() {

    /*
     * By using a TestScheduler we can advance the time by hand and in this way
     * we can test time-sensitive Observables.
     */

    val testScheduler = TestScheduler()

    val fastObservable = Observable
        .interval(10, TimeUnit.MILLISECONDS, testScheduler)
        .map { "F$it" }
        .take(5)
    val slowObservable = Observable
        .interval(50, TimeUnit.MILLISECONDS, testScheduler)
        .map { "S$it" }
        .take(5)

    fastObservable.concatWith(slowObservable)
        .subscribe {
            println(it)
        }
    println("Subscribed")

    TimeUnit.SECONDS.sleep(1)
    println("After one second")
    testScheduler.advanceTimeBy(25, TimeUnit.MILLISECONDS)

    TimeUnit.SECONDS.sleep(1);
    println("After one more second");
    testScheduler.advanceTimeBy(75, TimeUnit.MILLISECONDS)

    TimeUnit.SECONDS.sleep(1)
    println("...and one more")
    testScheduler.advanceTimeTo(200, TimeUnit.MILLISECONDS)

}