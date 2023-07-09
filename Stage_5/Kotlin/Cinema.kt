package cinema

fun main() {
    // write your code here
    println("Enter the number of rows:")
    val row: Int = readln().toInt()

    println("Enter the number of seats in each row:")
    val seats: Int = readln().toInt()

    val cinema = Array(row) { IntArray (seats) }
    val totalSeats = row * seats
    val totalIncome = calculateTotalIncome(row, seats)
    var purchaseCount = 0
    var currentIncome = 0

    while (true) {
        printMenu();

        try {
            when (readln().toInt()) {
                1 -> printCinema(cinema)
                2 -> {
                    val ticketPrice = purchaseSeat(cinema, totalSeats)
                    println("Ticket price: $$ticketPrice")

                    purchaseCount ++
                    currentIncome += ticketPrice
                }
                3 -> {
                    println("\nNumber of purchased tickets: $purchaseCount")

                    val percent: Float = (purchaseCount.toFloat() / totalSeats) * 100
                    println("Percentage: ${"%.2f".format(percent)}%")

                    println("Current income: $$currentIncome")
                    println("Total income: $$totalIncome")
                }
                0 -> break;
            }
        } catch (e: Exception) {
            println("Wrong input!")
        }
    }
}

fun printMenu() {
    println(
        """
            
            1. Show the seats
            2. Buy a ticket
            3. Statistics
            0. Exit
        """.trimIndent())
}

fun purchaseSeat(cinema: Array<IntArray>, totalSeats: Int): Int {
    var row = -1
    var col = -1

    while (true) {
        try {
            println("\nEnter a row number:")
            row = readln().toInt()

            println("Enter a seat number in that row:")
            col = readln().toInt()

            if (cinema[row - 1][col - 1] == 0) {
                break;
            }
            println("\nThat ticket has already been purchased!")
        } catch (e: Exception) {
            println("\nWrong input!")
        }
    }

    cinema[row - 1][col - 1] = 1

    var ticketPrice: Int  = 10
    if (totalSeats >= 60) {
        ticketPrice = if (row <= cinema.size / 2) 10 else 8;
    }

    return ticketPrice
}

fun calculateTotalIncome(row: Int, seatsInRow: Int): Int {
    val totalSeats = row * seatsInRow
    var totalIncome: Int  = 0

    if (totalSeats >= 60) {
        totalIncome = (((row / 2) * seatsInRow) * 10) + (((row - (row / 2)) * seatsInRow) * 8)
    } else {
        totalIncome =  totalSeats * 10
    }

    return totalIncome
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
}