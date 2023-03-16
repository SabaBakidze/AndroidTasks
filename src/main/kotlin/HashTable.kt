class HashTable {
    private val size = 10
    private val table = Array(size) { mutableListOf<Pair<Any, Any>>() }

    private fun hash(key: Any): Int {
        return key.hashCode() % size
    }

    fun add(key: Any, value: Any) {
        val hashValue = hash(key)
        if (table[hashValue].isEmpty()) {
            table[hashValue] = mutableListOf(Pair(key, value))
        } else {
            table[hashValue].add(Pair(key, value))
        }
    }

    fun remove(key: Any) {
        val hashValue = hash(key)
        if (table[hashValue].isEmpty()) {
            throw NoSuchElementException("Key not found")
        } else {
            for (pair in table[hashValue]) {
                if (pair.first == key) {
                    table[hashValue].remove(pair)
                    return
                }
            }
            throw NoSuchElementException("Key not found")
        }
    }
}
