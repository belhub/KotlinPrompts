package shared.ui.onboarding

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import shared.core.design.AppAccent

@Composable
fun PagerIndicator(
    currentPage: Int,
    pageCount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        repeat(pageCount) { page ->
            val isActive = page == currentPage
            val indicatorColor = animateColorAsState(
                targetValue = if (isActive) AppAccent else MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
                label = "pagerIndicatorColor",
            )

            Box(
                modifier = Modifier
                    .width(if (isActive) 24.dp else 8.dp)
                    .height(8.dp)
                    .clip(CircleShape)
                    .background(indicatorColor.value),
            )
        }
    }
}