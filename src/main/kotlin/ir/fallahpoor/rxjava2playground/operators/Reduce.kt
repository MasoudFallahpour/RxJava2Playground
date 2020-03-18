package ir.fallahpoor.rxjava2playground.operators

import io.reactivex.Maybe
import io.reactivex.Observable

fun main() {

    /*
     * reduce() applies a function to the first item emitted by the source Observable and then
     * feeds the result of the function back into the function along with the second item emitted
     * by the source Observable, continuing this process until the source Observable emits its
     * final item and completes, whereupon the Observable returned from Reduce emits the final
     * value returned from the function.
     * This sort of operation is sometimes called “accumulate,” “aggregate,” “compress,” “fold,”
     * or “inject”.
     */

    val n = 5
    print("Factorial of $n is ")
    factorial1(n)
        .subscribe {
            println(it)
        }

}

fun factorial1(n: Int): Maybe<Int> =
    Observable.range(1, n)
        .reduce { f: Int, i: Int -> f * i }