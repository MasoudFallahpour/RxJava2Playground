package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable

// Example is from https://blog.danlew.net/2014/09/22/grokking-rxjava-part-2/

fun main() {

    /*
     * We want to make a robust system for searching website URLs and displaying the results.
     */

    /*
     * The following solution is highly unsatisfactory because we lose the ability to transform
     * the data stream.
     * If we wanted to modify each URL, We'd have to do it all in the Subscriber.
     */
    query("Hello, world!")
        .subscribe { urls: List<String> ->
            for (url in urls) {
                println(url)
            }
        }

    /*
     * In the following solution We've gotten rid of the 'for' loop, but the resulting code
     * is a mess. We've got nested subscriptions now. It's ugly and hard to modify.
     * Remember that one of RxJava advantages was to get rid of nested callbacks but now we're
     * having nested subscriptions!
     */
    query("Hello, world!")
        .subscribe { urls: List<String> ->
            Observable.fromIterable(urls)
                .subscribe { url: String -> println(url) }
        }

    /*
     * The final solution takes advantage of flatMap() to get rid of nested subscription.
     *
     * flatMap() transforms the items emitted by an Observable into Observables,
     * then flattens the emissions from those into a single Observable.
     * Conceptually flatMap() takes Observable<T> and a function from T to Observable<R>.
     * flatMap() first constructs Observable<Observable<R>> replacing all upstream values
     * of type T with Observable<R> (just like map()). However, it does not stop there: it
     * automatically subscribes to these inner Observable<R> streams to produce a single
     * stream of type R, containing all values from all inner streams, as they come.
     *
     * flatMap() does NOT guarantee any specific order of events. So interleaving of events of
     * Observables may occur.
     */

    query("Hello, world!")
        .flatMap { urls: List<String> -> Observable.fromIterable(urls) }
        .subscribe { url: String -> println(url) }

    /*
     * The following solution is a better version of above one. It's using the
     * flatMapIterable operator to get rid of that lengthy flatMap of previous solution.
     */
    query("Hello, world!")
        .flatMapIterable { urls: List<String> -> urls }
        .subscribe { url: String -> println(url) }

}

// Returns a list of website URLs based on a text search
fun query(text: String): Observable<List<String>> {
    return Observable.just(listOf("http://www.google.com", "http://www.amazon.com", "http://fallahpoor.ir"))
}