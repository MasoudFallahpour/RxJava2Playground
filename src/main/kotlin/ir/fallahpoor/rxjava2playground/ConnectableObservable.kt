package ir.fallahpoor.rxjava2playground

import ir.fallahpoor.rxjava2playground.creation.CreateObservable

fun main() {

    /*
     * A ConnectableObservable resembles an ordinary Observable, except that it does not begin emitting
     * items when it is subscribed to, but only when its connect() method is called.
     * To convert an Observable to a ConnectableObservable call publish() on the Observable.
     */
    val connectableObservable = CreateObservable().create().publish()

    Logger.logMessage("Before subscribing")

    // Here we subscribe to the observable but subscribing does not cause the observable to
    // start emitting items.
    connectableObservable
        .subscribe {
            Logger.logMessage("Subscriber #1 -> onNext: $it")
        }
    Logger.logMessage("Subscriber #1 is subscribed")

    connectableObservable
        .subscribe {
            Logger.logMessage("Subscriber #2 -> onNext: $it")
        }
    Logger.logMessage("Subscriber #2 is subscribed")

    Logger.logMessage("After subscribing")

    Logger.logMessage("Sleeping for 2 seconds")
    Thread.sleep(2000)

    Logger.logMessage("Connecting to Observable")
    connectableObservable.connect()

}

