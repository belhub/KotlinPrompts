package shared.ui.recipes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.data.recipesMock
import shared.models.Recipe
import shared.models.RecipeType

@Composable
fun RecipesScreen(
    recipes: List<Recipe> = recipesMock,
    onOpenRecipe: (Recipe) -> Unit = {},
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedType by remember { mutableStateOf<RecipeType?>(null) }
    var selectedPrepTime by remember { mutableStateOf<RecipePrepTimeFilter>(RecipePrepTimeFilter.All) }

    val filteredRecipes = recipes.filter { recipe ->
        val matchesSearch = recipe.name.contains(searchQuery.trim(), ignoreCase = true)
        val matchesType = selectedType == null || recipe.type == selectedType
        val matchesPrepTime = selectedPrepTime.matches(recipe.prepTime)
        matchesSearch && matchesType && matchesPrepTime
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        item {
            RecipeFiltersSection(
                searchQuery = searchQuery,
                onSearchQueryChange = { searchQuery = it },
                selectedType = selectedType,
                onTypeSelected = { selectedType = it },
                selectedPrepTime = selectedPrepTime,
                onPrepTimeSelected = { selectedPrepTime = it },
            )
        }

        items(filteredRecipes) { recipe ->
            RecipeCard(recipe = recipe, onClick = { onOpenRecipe(recipe) })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeFiltersSection(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    selectedType: RecipeType?,
    onTypeSelected: (RecipeType?) -> Unit,
    selectedPrepTime: RecipePrepTimeFilter,
    onPrepTimeSelected: (RecipePrepTimeFilter) -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = { Text(text = "Szukaj przepisu") },
            placeholder = { Text(text = "Wpisz nazwę przepisu") },
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.horizontalScroll(rememberScrollState()),
        ) {
            FilterChip(
                selected = selectedType == null,
                onClick = { onTypeSelected(null) },
                label = { Text(text = "Wszystkie") },
            )

            RecipeType.entries.forEach { type ->
                FilterChip(
                    selected = selectedType == type,
                    onClick = { onTypeSelected(type) },
                    label = { Text(text = type.name) },
                )
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = "Czas przygotowania", style = MaterialTheme.typography.titleSmall)

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.horizontalScroll(rememberScrollState()),
            ) {
                RecipePrepTimeFilter.entries.forEach { filter ->
                    FilterChip(
                        selected = selectedPrepTime == filter,
                        onClick = { onPrepTimeSelected(filter) },
                        label = { Text(text = filter.label) },
                    )
                }
            }
        }
    }
}

enum class RecipePrepTimeFilter(val label: String) {
    All("Wszystkie"),
    UpTo10("≤ 10 min"),
    UpTo20("≤ 20 min"),
    UpTo30("≤ 30 min"),
    Over30("> 30 min");

    fun matches(prepTime: Int): Boolean = when (this) {
        All -> true
        UpTo10 -> prepTime <= 10
        UpTo20 -> prepTime <= 20
        UpTo30 -> prepTime <= 30
        Over30 -> prepTime > 30
    }
}