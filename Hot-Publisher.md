## Hot Publisher

| Method| Usage| 
|--|--|
| share, publish().refCount(1)|At least 1 subscriber. It will reconnect later when all the subscribers cancelled and some new subscriber appears. 
|publish().autoConnect(1)| same as above. but no resubscription. if the source emits, subscribers will receive item. 
publish().autoConnect(0)| real hot publisher - no subscriber required
cache| Cache the emitted item for late subscribers 