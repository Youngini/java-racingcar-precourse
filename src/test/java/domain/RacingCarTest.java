package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    @DisplayName("자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    @CsvSource({"4,1", "5,1", "6,1",
            "0,0", "1,0", "3,0"})
    void carMoveOrStopByRandomNumber(int givenPower, int curLocation) {
        // given
        int startLocation = 0;
        RacingCar car = new RacingCar("ini", startLocation);

        // when
        car.move(givenPower);

        // then
        assertThat(car.getDistance()).isEqualTo(curLocation);
    }

    @DisplayName("같은 위치의 자동차가 존재하는지 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource({"2,2,true","2,1,false"})
    void isSameDistanceOfCar(int myCarLocation,
                             int competeCarLocation,
                             boolean sameDistanceCheck) throws Exception{
        //given
        RacingCar myCar = new RacingCar("ini", myCarLocation);
        RacingCar competeCar = new RacingCar("yoni", competeCarLocation);

        //when
        boolean sameDistance = myCar.isSameDistance(competeCar);

        //then
        assertThat(sameDistance).isEqualTo(sameDistanceCheck);
    }
}
