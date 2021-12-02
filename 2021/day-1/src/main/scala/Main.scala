import scala.io.Source

@main def day1(inputFileName: String): Unit =
  val depths = Source.fromFile(inputFileName).getLines.map(_.toInt).toList
  val numIncreases = countIncreases(depths)
  println(s"Total depth increases: $numIncreases")

def countIncreases(depths: List[Int]): Int =
  var increaseCount = 0;
  var prevDepth = depths.head

  for depth <- depths.tail do
    val change = getChange(prevDepth, depth)

    if didIncrease(change) then
      increaseCount += 1

    prevDepth = depth
  
  return increaseCount

def getChange(prevDepth: Int, curDepth: Int): Int = curDepth - prevDepth
def didIncrease(depthChange: Int): Boolean = depthChange > 0

// TODO: One line solution