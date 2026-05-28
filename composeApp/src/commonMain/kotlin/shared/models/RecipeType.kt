package shared.models

import kotlinx.serialization.Serializable

@Serializable
enum class RecipeType {
    Śniadanie,
    Obiad,
    Kolacja,
    Deser
}

@Serializable
data class Recipe(
    val id: String,
    val name: String,
    val prepTime: Int,
    val servings: Int,
    val type: RecipeType,
    val image: String,
    val ingredients: List<Ingredient>,
    val steps: List<String>
)
