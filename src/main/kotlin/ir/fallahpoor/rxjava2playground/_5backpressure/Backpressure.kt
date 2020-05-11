package ir.fallahpoor.rxjava2playground._5backpressure

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {

    /*
     * Observable does NOT support backpressure. It means if the Observable produces items faster
     * that what the observer can consume then observer falls behind and can never catch up with the
     * Observable.
     *
     * If you need backpressure support then you should use Flowable. One could think of Flowable as
     * a backpressure-enabled Observable.
     */

    val dishes1: Observable<Dish> = Observable.range(1, 200)
        .map {
            Dish(it.toLong())
        }
    dishes1
        .observeOn(Schedulers.io())
        .subscribe {
            println("Washing $it")
            TimeUnit.MILLISECONDS.sleep(50)
        }

    val dishes2: Flowable<Dish> = Flowable.range(1, 200)
        .map {
            Dish(it.toLong())
        }
    dishes2
        .observeOn(Schedulers.io())
        .subscribe {
            println("Washing $it")
            TimeUnit.MILLISECONDS.sleep(50)
        }

    TimeUnit.SECONDS.sleep(15)

}

private class Dish(private val id: Long) {

    private val onKb = ByteArray(1024)

    init {
        println("Dish #$id created")
    }

    override fun toString() = id.toString()

}