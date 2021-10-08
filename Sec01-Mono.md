
| Type | Condition | What to Use
|--|--|--|
| Create Mono |Data already present  | Mono.just(data) 
|Create Mono | Data to be calculated | Mono.fromSupplier(()->getData()),    Mono.fromCallable()->getData())
Crate Mono | Data is commming from async completableFuture | Mono.fromFuture(future)
Create Mono| Emit empty once a given ruunable is complete | Mono.fromRunnable(runnable)
Pass Mono as argument | Function accepts a Mono<Address>. But I do not have data | Mono.empty()
Return Mono | Function needs to return a Mono | Mono.error() Mono.empty() ,  above creation type
