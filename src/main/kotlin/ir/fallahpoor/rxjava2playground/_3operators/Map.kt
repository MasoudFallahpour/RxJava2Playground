package ir.fallahpoor.rxjava2playground._3operators

import io.reactivex.Observable

fun main() {

    val tagsObservable = Observable.create<String> {
        val tags = arrayOf("html", "head", "title", "body", "h1", "table")
        for (tag in tags) {
            it.onNext(tag)
        }
    }

    tagsObservable
        .map {
            "<$it>"
        }
        .subscribe {
            println(it)
        }

}