package shared.ui.recipes

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest

@Composable
fun RecipeImage(imageUrl: String, modifier: Modifier = Modifier) {
    val context = LocalPlatformContext.current
    val placeholderPainter = rememberVectorPainter(Icons.Default.Image)
    val errorPainter = rememberVectorPainter(Icons.Default.BrokenImage)

    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(imageUrl)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        placeholder = placeholderPainter,
        error = errorPainter,
        fallback = errorPainter,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
            .clip(RoundedCornerShape(12.dp)),
    )
}