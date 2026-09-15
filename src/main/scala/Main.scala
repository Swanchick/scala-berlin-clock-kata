@main
def main(): Unit =
  println(parseInt("153") + 2)

  println(parseTime("10:00:00").mkString(", "))

def reduce[A, B](fn: (B, A) => B, seq: List[A], acc: B): B =
  seq match
    case head :: tail => reduce(fn, tail, fn(acc, head))
    case Nil          => acc

def map[A, B](seq: List[A], fn: A => B): List[B] =
  reduce(
    (acc: List[B], x: A) => acc :+ fn(x),
    seq,
    List.empty[B]
  )

def range(n: Int, m: Int): List[Int] =
  n < m match
    case true  => n +: range(n + 1, m)
    case false => List.empty

def reverse[T](list: List[T]): List[T] =
  list match
    case head :: tail => reverse(tail) :+ head
    case Nil          => List.empty

def charToInt(char: Char): Int = char - '0'

def pow(a: Int, b: Int): Int =
  b match
    case 0 => 1
    case 1 => a
    case _ =>
      a * pow(a, b - 1)

def parseIntRec(value: List[Char], iter: Int): Int =
  value match
    case head :: tail =>
      charToInt(head) * pow(10, iter) + parseIntRec(tail, iter + 1)
    case Nil => 0

def parseInt(value: String): Int =
  parseIntRec(reverse(value.toList), 0)

def parseTimeRec(timeTail: List[Char], acc: String): List[Int] =
  timeTail match
    case ':' :: tail =>
      parseInt(acc) +: parseTimeRec(tail, "")
    case char :: tail =>
      parseTimeRec(tail, acc + char)
    case Nil =>
      List(parseInt(acc))

def parseTime(time: String): List[Int] =
  parseTimeRec(time.toList, "")

def toBerlinClock(time: String): String =
  val timeInt = parseTime(time)

  val seconds = timeInt(2) % 2 == 0 match
    case true  => ".";
    case false => "X"

  // ". .... .... ........... ...."
  seconds + " .... .... ........... ...."
