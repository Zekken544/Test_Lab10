package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusTest {
    @Test
    void bonus_longStreakBelowThreshold_returns3() {
        assertEquals(3, DataFlowTargets.bonus(new int[]{1, 0, 1, 1, 1, 1, 1}, 7));
    }

    @Test
    void bonus_emptyAttendanceAtZeroThreshold_returns5() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{}, 0));
    }
    @Test
    void bonus_nullAttendance_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> DataFlowTargets.bonus(null, 0));
    }

    @Test
    void bonus_negativeThreshold_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> DataFlowTargets.bonus(new int[]{}, -1));
    }

    @Test
    void bonus_belowThresholdWithShortStreak_returns0() {
        assertEquals(0, DataFlowTargets.bonus(new int[]{1, 0, 1, 1, 1, 1}, 6));
    }

    @Test
    void bonus_thresholdMetWithLongStreak_returns8() {
        assertEquals(8, DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1}, 5));
    }
    @Test
    void bonus_emptyAttendanceBelowThreshold_returns0() {
        assertEquals(0, DataFlowTargets.bonus(new int[]{}, 1));
    }
}