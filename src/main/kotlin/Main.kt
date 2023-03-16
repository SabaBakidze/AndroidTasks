fun main() {

    //Task 1
    println("----- Task 1")
    val arrToCheck = arrayOf(3, 4, 5, 6, 3, 4, 5, 6, 7)
    val singleNumber = singleNumber(arrToCheck)
    if (singleNumber == 0)
        println("Each integer appears more than once")
    else
        println("The number that appears once is: $singleNumber")


    //Task 2
    println("\n----- Task 2")
    val cashToSplit = 197
    println("Coins required to split $cashToSplit: ${minSplit(cashToSplit)}")
}

//Task 1 function, using bitwise operator XOR
fun singleNumber(arr: Array<Int>): Int{
    var singleNum = 0
    for (num in arr)
        singleNum = singleNum xor num
    return singleNum
}

//Task 2 function,
fun minSplit(cash: Int): Map<Int, Int>{
    val result = mutableMapOf<Int, Int>()
    val coins = intArrayOf(50, 20, 10, 5, 1)
    var remaining = cash
    var coinIndex = 0
    while (remaining > 0 && coinIndex < coins.size){
        val coin = coins[coinIndex]
        val count = remaining/coin
        if (count > 0) {
            result[coin] = count
            remaining %= coin
        }
        coinIndex++
    }

    return result
}