package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable

fun main() {

    /*
     * take(n) operator will truncate the source Observable prematurely after
     * emitting only the first n events from upstream, unsubscribing afterward
     * (or complete earlier if upstream did not have n items)
     */
    Observable.range(1, 5)
        .take(3)
        .forEach {
            print("$it ")
        }

    println()

    Observable.range(1, 5)
        .take(10)
        .forEach {
            print("$it ")
        }

    println()

    /*
     * skip(n) discards the first n elements and begins emitting events from the upstream
     * Observable beginning with event n+1.
     */
    Observable.range(1, 5)
        .skip(3)
        .forEach {
            print("$it ")
        }

    println()

    Observable.range(1, 5)
        .skip(5)
        .forEach {
            print("$it ")
        }

    println()

    /*
     * takeLast(n) emits only the last n values from the stream before it completes.
     * Internally, this operator must keep a buffer of the last n values and when it
     * receives completion notification, it immediately emits the entire buffer.
     */
    Observable.range(1, 5)
        .takeLast(2)
        .forEach {
            print("$it ")
        }

    println()

    /*
     * skipLast(n) emits all values from upstream Observable except the last n.
     * Internally, skipLast() can emit the first value from upstream only when it
     * received n+1 elements, second when it received n+2, and so on.
     */
    Observable.range(1, 5)
        .skipLast(2)
        .forEach {
            print("$it ")
        }

    println()

    /*
     * first(i) emits only the very first item emitted by the Observable, or i if the
     * Observable completes without emitting any items.
     */
    Observable.just(45, 6, 55, 13, 21)
        .first(100)
        .subscribe { i ->
            print("$i")
        }

    println()

    /*
     * last(i) emits only the very last item emitted by the Observable, or i if the
     * Observable completes without emitting any items.
     */
    Observable.just(45, 6, 55, 13, 21)
        .last(200)
        .subscribe { i ->
            print("$i")
        }

    println()

    /*
     * takeUntil(predicate) emits values from the source Observable but completes and
     * unsubscribes after emitting the very first value matching predicate.
     */
    Observable.range(10, 20)
        .takeUntil {
            it >= 15
        }
        .forEach {
            print("$it ")
        }

    println()

    /*
     * takeWhile(predicate) emits values as long as they match the given predicate.
     */
    Observable.just(5, 10, 15, 20, 25, 31, 42)
        .takeWhile {
            it % 5 == 0
        }
        .forEach {
            print("$it ")
        }

    println()

    /*
     * count() calculates how many events were emitted by the Observable.
     */
    Observable.just(5, 10, 15, 20, 25, 31, 42)
        .count()
        .subscribe { count -> print(count) }

}