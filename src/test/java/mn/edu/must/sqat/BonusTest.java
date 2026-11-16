package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
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
}