package shared.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.changedToUpIgnoreConsumed
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.input.pointer.positionChangeIgnoreConsumed
import shared.core.design.AppBackground
import shared.core.design.AppPrimary
import shared.core.design.AppSecondary
import shared.core.design.AppSpacing

private data class OnboardingSlideContent(
    val title: String,
    val description: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val accentColor: androidx.compose.ui.graphics.Color,
)

@Composable
fun OnboardingPager(
    onFinished: () -> Unit,
    modifier: Modifier = Modifier,
    state: OnboardingState = rememberOnboardingState(),
) {
    val slides = listOf(
        OnboardingSlideContent(
            title = "Discover recipes faster",
            description = "Browse curated ideas and jump straight into meals that match your mood.",
            icon = Icons.Filled.RestaurantMenu,
            accentColor = AppPrimary,
        ),
        OnboardingSlideContent(
            title = "Find what you need",
            description = "Search recipes by taste, ingredients, or time so planning stays simple.",
            icon = Icons.Filled.Search,
            accentColor = AppSecondary,
        ),
        OnboardingSlideContent(
            title = "Save your favorites",
            description = "Keep the recipes you love in one place and return to them anytime.",
            icon = Icons.Filled.Favorite,
            accentColor = MaterialTheme.colorScheme.tertiary,
        ),
    )

    val density = LocalDensity.current
    val swipeThresholdPx = remember(density) { with(density) { 72.dp.toPx() } }
    val pagerState = rememberPagerState(
        initialPage = state.currentSlide,
        pageCount = { slides.size },
    )

    val finishTriggered = remember { mutableStateOf(false) }
    val currentOnFinished = rememberUpdatedState(onFinished)

    val pagerGestureModifier = Modifier.pointerInput(pagerState.currentPage, onFinished) {
        awaitEachGesture {
            val firstDown = awaitFirstDown(requireUnconsumed = false)
            var totalHorizontalDistance = 0f
            var lastHorizontalDirection = 0f

            while (true) {
                val event = awaitPointerEvent(PointerEventPass.Main)
                val change = event.changes.firstOrNull { it.id == firstDown.id } ?: break

                val positionChange = change.positionChangeIgnoreConsumed()
                if (positionChange.x != 0f) {
                    totalHorizontalDistance += positionChange.x
                    lastHorizontalDirection = positionChange.x
                }

                if (change.changedToUpIgnoreConsumed()) {
                    if (
                        pagerState.currentPage == slides.lastIndex &&
                        totalHorizontalDistance < -swipeThresholdPx &&
                        lastHorizontalDirection < 0f &&
                        !finishTriggered.value
                    ) {
                        finishTriggered.value = true
                        currentOnFinished.value()
                    }
                    break
                }
            }
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        state.currentSlide = pagerState.currentPage
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppBackground)
            .systemBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = AppSpacing.screenPadding),
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .then(pagerGestureModifier),
        ) { page ->
            OnboardingSlide(
                title = slides[page].title,
                description = slides[page].description,
                icon = slides[page].icon,
                accentColor = slides[page].accentColor,
                modifier = Modifier.fillMaxSize(),
            )
        }

        PagerIndicator(
            currentPage = state.currentSlide,
            pageCount = slides.size,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
        )
    }
}