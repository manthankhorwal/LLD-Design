### LRU cache  
* Cache is a service with contains a map to store key value pair and which opt for LRU eviction policy , both are implemented , so both can be treated as different implementation , and cache uses LRU policy.
* Cache is implemented which has a map and a eviction policy. Value is returned from this map storage only.And we can assign a eviction policy to this cache.
* LRU Eviction policy is implemented which contains doubly linked list of keys and it also keeps map to store addrresses of the nodes of linked list , map is used to make retrevial at O(1).
* Linked list is used to keep what key is recently used and what was least recently used and we can take decision what to evict .
