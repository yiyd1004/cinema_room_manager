package cinema

fun main() {
    // write your code here
    println("Enter the number of rows:")
    val row: Int = readln().toInt()

    println("Enter the number of seats in each row:")
    val seats: Int = readln().toInt()

    val totalSeats: Int = row * seats
    var totalIncome: Int  = 0

    if (totalSeats >= 60) {
        totalIncome = (((row / 2) * seats) * 10) + (((row - (row / 2)) * seats) * 8)
    } else {
        totalIncome =  totalSeats * 10
    }
    println("Total income:")
    println("$$totalIncome")
}