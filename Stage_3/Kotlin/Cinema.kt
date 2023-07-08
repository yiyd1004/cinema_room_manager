package cinema

fun main() {
    // write your code here
    println("Enter the number of rows:")
    val row: Int = readln().toInt()

    println("Enter the number of seats in each row:")
    val seats: Int = readln().toInt()

    val cinema = Array(row) { IntArray (seats) }
    printCinema(cinema);

    val ticketPrice = purchaseSeat(cinema)
    println("\nTicket price: $$ticketPrice")
    printCinema(cinema)
}

fun purchaseSeat(cinema: Array<IntArray>): Int {
    val totalSeats: Int = cinema.size * cinema[0].size

    println("Enter a row number:")
    val row = readln().toInt()

    println("Enter a seat number in that row:")
    val col = readln().toInt()

    cinema[row - 1][col - 1] = 1

    var ticketPrice: Int  = 10
    if (totalSeats >= 60) {
        ticketPrice = if (row <= cinema.size / 2) 10 else 8;
    }

    return ticketPrice
}

fun printCinema(cinema: Array<IntArray>) {
    println("\nCinema:")

    var firstLine = " "
    for (i in 1 .. cinema[0].size) {
        firstLine += " $i"
    }
    println(firstLine)

    for (i in cinema.indices) {
        var line: String = "";

        for (j in cinema[i].indices) {
            val state = if (cinema[i][j] == 0) 'S' else 'B'
            if (j == 0) {
                line += "${i + 1} $state"
            } else {
                line += " $state"
            }
        }

        println(line)
    }
    println()
}