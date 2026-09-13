@main
def main(): Unit =
  println(toBerlinClock("10:00:00"))

def toBerlinClock(time: String): String =
  ". .... .... ........... ...."
