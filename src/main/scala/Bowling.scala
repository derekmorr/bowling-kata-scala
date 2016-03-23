import scala.language.postfixOps

import scalaz.syntax.equal._
import scalaz.std.anyVal._

object Bowling {

  type IntermediateResult = (Int, List[Int])

  private def scoreFrame(score: Int, throws: List[Int]): IntermediateResult = throws match {
    // strike
    case 10 :: tail => {
      val frameScore = 10 + (tail take 2 sum)
      (score + frameScore, tail)
    }
    // spare
    case first :: second :: tail if first + second === 10 => {
      val frameScore = 10 + (throws take 1 sum)
      (score + frameScore, tail)
    }
    // regular throw
    case first :: second :: tail =>
      val frameScore = first + second
      (score + frameScore, tail)
  }

  def score(throws: List[Int]): Int = {
    val initialResult = (0, throws)
    val (totalScore, _) = (1 to 10).foldLeft(initialResult) {
      case ((score, throwsRemaining), _) => scoreFrame(score, throwsRemaining)
    }

    totalScore
  }

}
