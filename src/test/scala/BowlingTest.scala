/**
  * Unit tests for bowling scores.
  */
class Bowling2Test extends BaseTest {

  "Bowling2" must {
    "score games" when {
      "all gutter balls (all zero)" ignore {
        val frames = List(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
        Bowling.score(frames) must === (0)
      }

      "all threes" ignore {
        val frames = List(3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3)
        Bowling.score(frames) must === (60)
      }

      "all spares with first ball a 4" ignore {
        val frames = List(4,6,4,6,4,6,4,6,4,6,4,6,4,6,4,6,4,6,4,6,4)
        Bowling.score(frames) must === (140)
      }

      "nine strikes followed by a gutter ball" ignore {
        val frames = List(10,10,10,10,10,10,10,10,10,0,0)
        Bowling.score(frames) must === (240)
      }

      "perfect game" ignore {
        val frames = List(10,10,10,10,10,10,10,10,10,10,10,10)
        Bowling.score(frames) must === (300)
      }
    }
  }

}