package shared.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import shared.core.design.AppAccent
import shared.core.design.AppSpacing
import shared.ui.home.HomeScreen
import shared.ui.recipes.RecipeDetailsScreen
import shared.ui.recipes.RecipesScreen
import shared.ui.settings.SettingsScreen
import shared.ui.shoppinglist.ShoppingItem
import shared.ui.shoppinglist.ShoppingListScreen
import shared.ui.shoppinglist.ShoppingUnit
import shared.models.Ingredient
import shared.models.Recipe
import kotlin.random.Random
import kotlinx.coroutines.launch

@Composable
fun AppNavigation(initialDestination: AppDestination = AppDestination.Home) {
    var selectedDestination by remember(initialDestination) { mutableStateOf(initialDestination) }
    var selectedRecipe by remember { mutableStateOf<Recipe?>(null) }
    val shoppingItems = remember { mutableStateListOf<ShoppingItem>() }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    fun addShoppingItem(name: String, quantity: Int, unit: ShoppingUnit) {
        shoppingItems.add(
            ShoppingItem(
                id = Random.nextLong().toString(),
                name = name,
                quantity = quantity,
                unit = unit,
            ),
        )
    }

    fun removeShoppingItem(itemId: String) {
        shoppingItems.removeAll { it.id == itemId }
    }

    fun updateShoppingItemStatus(itemId: String, purchased: Boolean) {
        val itemIndex = shoppingItems.indexOfFirst { it.id == itemId }
        if (itemIndex >= 0) {
            shoppingItems[itemIndex] = shoppingItems[itemIndex].copy(isPurchased = purchased)
        }
    }

    fun addRecipeIngredientsToShoppingList(recipe: Recipe) {
        recipe.ingredients.forEach { ingredient ->
            val shoppingItem = ingredient.toShoppingItemOrNull() ?: return@forEach
            val matchingItemIndex = shoppingItems.indexOfFirst {
                it.name.equals(shoppingItem.name, ignoreCase = true) && it.unit == shoppingItem.unit
            }

            if (matchingItemIndex >= 0) {
                val existingItem = shoppingItems[matchingItemIndex]
                shoppingItems[matchingItemIndex] = existingItem.copy(quantity = existingItem.quantity + shoppingItem.quantity)
            } else {
                shoppingItems.add(shoppingItem)
            }
        }

        coroutineScope.launch {
            snackbarHostState.showSnackbar(
                message = "Składniki dodano do listy zakupów",
                duration = SnackbarDuration.Short,
            )
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = {
            NavigationBar(
                modifier = Modifier.padding(horizontal = AppSpacing.navigationPadding),
            ) {
                AppDestination.entries.forEach { destination ->
                    NavigationBarItem(
                        selected = selectedDestination == destination,
                        onClick = {
                            selectedDestination = destination
                            if (destination != AppDestination.Recipes) {
                                selectedRecipe = null
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = destination.icon,
                                contentDescription = destination.label,
                            )
                        },
                        label = { Text(destination.label) },
                        alwaysShowLabel = true,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = AppAccent,
                            selectedTextColor = AppAccent,
                            unselectedIconColor = androidx.compose.ui.graphics.Color.Gray,
                            unselectedTextColor = androidx.compose.ui.graphics.Color.Gray,
                            indicatorColor = AppAccent.copy(alpha = 0.12f),
                        ),
                    )
                }
            }
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center,
        ) {
            when (selectedDestination) {
                AppDestination.Home -> HomeScreen(
                    onFinished = { selectedDestination = AppDestination.Recipes },
                )
                AppDestination.Recipes -> {
                    RecipesScreen(onOpenRecipe = { selectedRecipe = it })

                    selectedRecipe?.let { recipe ->
                        RecipeDetailsScreen(
                            recipe = recipe,
                            onBack = { selectedRecipe = null },
                            onAddIngredientsToShoppingList = {
                                addRecipeIngredientsToShoppingList(recipe)
                            },
                        )
                    }
                }
                AppDestination.ShoppingList -> ShoppingListScreen(
                    shoppingItems = shoppingItems,
                    onAddItem = ::addShoppingItem,
                    onRemoveItem = ::removeShoppingItem,
                    onUpdateItemStatus = ::updateShoppingItemStatus,
                )
                AppDestination.Settings -> SettingsScreen()
            }
        }
    }
}

private fun Ingredient.toShoppingItemOrNull(): ShoppingItem? {
    val rawQuantity = quantity?.trim().orEmpty()
    val numericPrefix = Regex("^(\\d+)").find(rawQuantity)?.value
    val parsedQuantity = numericPrefix?.toIntOrNull() ?: 1
    val normalizedUnit = rawQuantity.removePrefix(numericPrefix.orEmpty()).trim().lowercase()

    val unit = when {
        normalizedUnit.startsWith("szt") -> ShoppingUnit.Piece
        normalizedUnit.startsWith("łyżki") || normalizedUnit.startsWith("łyżka") -> ShoppingUnit.Tablespoon
        normalizedUnit.startsWith("łyżeczki") || normalizedUnit.startsWith("łyżeczka") -> ShoppingUnit.Teaspoon
        normalizedUnit.startsWith("kromki") || normalizedUnit.startsWith("kromka") -> ShoppingUnit.Slice
        normalizedUnit == "g" || normalizedUnit.startsWith("gram") -> ShoppingUnit.Gram
        normalizedUnit == "kg" -> ShoppingUnit.Kilogram
        normalizedUnit == "ml" || normalizedUnit.startsWith("milil") -> ShoppingUnit.Milliliter
        normalizedUnit == "l" || normalizedUnit.startsWith("litr") -> ShoppingUnit.Liter
        normalizedUnit.startsWith("szkl") -> ShoppingUnit.Cup
        else -> ShoppingUnit.Piece
    }

    return ShoppingItem(
        id = Random.nextLong().toString(),
        name = name,
        quantity = parsedQuantity,
        unit = unit,
    )
}