## Flux 

| Type | Condition | What to Use
|--|--|--|
| Create Flux|Data already present  | Flux.just(data); Flux.fromIterable(); Flux.fromArray(); Flux.fromStream() 
|Create Flux| Range/Count | Flux.range(start, count)
Crate Flux| Periodic| Flux.interval(duration)
Create Flux| Mono -> Flux | Flux.from(mono)

