package shared

import androidx.compose.runtime.Composable
import shared.core.design.AppTheme
import shared.ui.navigation.AppNavigation

@Composable
fun App() {
    AppTheme {
        AppNavigation()
    }
}