

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("00:00:00") {
    assertEquals(toBerlinClock("00:00:00"), ". .... .... ........... ....")
  }

  test("00:00:01") {
    assertEquals(toBerlinClock("00:00:01"), "X .... .... ........... ....")
  }

  test("23:59:59") {
    assertEquals(toBerlinClock("23:59:59"), "X XXXX XXX. XX|XX|XX|XX XXXX")
  }

  test("18:48:02") {
    assertEquals(toBerlinClock("18:48:02"), ". XXX. XXX. XX|XX|XX|.. XXX.")
  }

  test("10:31:17") {
    assertEquals(toBerlinClock("10:31:17"), "X XX.. .... XX|XX|..... X...")
  }

  test("06:45:18") {
    assertEquals(toBerlinClock("06:45:18"), ". X... X... XX|XX|XX|.. ....")
  }
}
