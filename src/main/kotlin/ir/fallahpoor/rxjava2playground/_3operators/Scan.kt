package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable

fun main() {

    /*
     * scan() applies a function to the first item emitted by the source Observable and then
     * emits the result of that function as its own first emission. It also feeds the result
     * of the function back into the function along with the second item emitted by the source
     * Observable in order to generate its second emission. It continues to feed back its own
     * subsequent emissions along with the subsequent emissions from the source Observable in
     * order to create the rest of its sequence.
     * This sort of operator is sometimes called an “accumulator”.
     */

    factorial(5)
        .subscribe {
            println(it)
        }

}

fun factorial(n: Int): Observable<Int> =
    Observable.range(1, n)
        .scan { f: Int, i: Int -> f * i }