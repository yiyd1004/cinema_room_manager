package cinema

fun main() {
    // write your code here
    println("Cinema:")

    var firstLine = " "
    for (i in 1 .. 8) {
        firstLine += " $i"
    }
    println(firstLine)

    for (i in 1 .. 7) {
        var line: String = "";

        for (j in 0 .. 8) {
            if (j == 0) {
                line += "$i";
            } else {
                line += " S";
            }
        }

        println(line);
    }
}