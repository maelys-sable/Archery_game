package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.archery.presenter.TargetPresenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TargetPresenterTest {

    @Test
    void test_radius_view_gets_lower_when_distance_gets_greater_because_of_perspective() throws Exception{
        assertTrue(TargetPresenter.changeRadiusWithPerspective(3,2)>(TargetPresenter.changeRadiusWithPerspective(3,4)));
        assertTrue(TargetPresenter.changeRadiusWithPerspective(5,6)<(TargetPresenter.changeRadiusWithPerspective(5,3)));
    }

    @Test
    void should_throw_exception_when_divided_by_zero_for_radius_method() throws Exception {
        assertThrows(Exception.class,
                () -> TargetPresenter.changeRadiusWithPerspective(5,0));
    }

    @Test
    void test_y_axis_gets_lower_when_distance_gets_greater_because_of_perspective() throws Exception {
        assertTrue(TargetPresenter.changeYPositionWithPerspective(12,1)>(TargetPresenter.changeYPositionWithPerspective(12,9)));
        assertTrue(TargetPresenter.changeYPositionWithPerspective(8,5)<(TargetPresenter.changeYPositionWithPerspective(8,2)));
    }

    @Test
    void should_throw_exception_when_divided_by_zero_for_y_axis_method() throws Exception {
        assertThrows(Exception.class,
                () -> TargetPresenter.changeYPositionWithPerspective(5,0));
    }
}
