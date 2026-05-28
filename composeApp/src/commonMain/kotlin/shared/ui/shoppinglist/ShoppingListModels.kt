package shared.ui.shoppinglist

data class ShoppingItem(
    val id: String,
    val name: String,
    val quantity: Int,
    val unit: ShoppingUnit,
    val isPurchased: Boolean = false,
)

enum class ShoppingUnit(val label: String) {
    Piece("szt."),
    Tablespoon("łyżka"),
    Teaspoon("łyżeczka"),
    Slice("kromka"),
    Gram("g"),
    Kilogram("kg"),
    Milliliter("ml"),
    Liter("l"),
    Cup("szklanka"),
}
