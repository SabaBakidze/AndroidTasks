fun main() {

    //Task 1
    println("--- Task 1")
    val arrToCheck = arrayOf(3, 4, 5, 6, 3, 4, 5, 6, 7)
    val singleNumber = singleNumber(arrToCheck)
    if (singleNumber == 0)
        println("Each integer appears more than once")
    else
        println("The number that appears once is: $singleNumber")


    //Task 2
    println("\n--- Task 2")
    val cashToSplit = 197
    println("Coins required to split $cashToSplit: ${minSplit(cashToSplit)}")

    //Task 3
    println("\n--- Task 3")
    val arrayToCheck = arrayOf(-4, 2, 5, 10, 1, 3)
    println("The array doesn't contain integer: " + notContains(arrayToCheck))

    //Task 4
    println("\n--- Task 4")
    val a = "1010"
    val b = "1011"
    println("The sum is: ${binarySum(a, b)}")

}

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

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

//Task 3 function,
fun notContains(arr: Array<Int>): Int{
    var checkingNum = 0
    do {
        ++checkingNum
    }while (arr.contains(checkingNum))

    return checkingNum
}

//Task 4 function,
fun binarySum(a: String, b: String): String {
    var carry = 0
    var i = a.length - 1
    var j = b.length - 1
    val sb = StringBuilder()
    while (i >= 0 || j >= 0 || carry > 0) {
        val sum = (if (i >= 0) a[i--] - '0' else 0) + (if (j >= 0) b[j--] - '0' else 0) + carry
        carry = sum / 2
        sb.append(sum % 2)
    }
    return sb.reverse().toString()
}
