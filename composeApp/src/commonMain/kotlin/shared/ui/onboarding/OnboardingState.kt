package shared.ui.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class OnboardingState(initialSlide: Int = 0) {
    var currentSlide by mutableIntStateOf(initialSlide)
        internal set
}

@Composable
fun rememberOnboardingState(initialSlide: Int = 0): OnboardingState {
    return remember(initialSlide) {
        OnboardingState(initialSlide)
    }
}