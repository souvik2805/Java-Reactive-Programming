## Schedulers & Threading

| Schedulers Method| Usage| 
|--|--|
| boundedElastic| Network/time consuming calls|
parallel| CPU intensive tasks|
single| A single dedicated thread for one-off tasks
immediate| Current thread


## Operator for Scheduling

| Operators | Usage| 
|--|--|
| subscribeOn| for upstream|
publishOn | for downstream|