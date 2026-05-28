package shared.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppDestination(val label: String, val icon: ImageVector) {
    Home("Home", Icons.Filled.Home),
    Recipes("Recipes", Icons.Filled.RestaurantMenu),
    ShoppingList("Shopping List", Icons.Filled.ShoppingCart),
    Settings("Settings", Icons.Filled.Settings),
}