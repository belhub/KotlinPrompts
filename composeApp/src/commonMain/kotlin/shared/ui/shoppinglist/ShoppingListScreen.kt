package shared.ui.shoppinglist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingListScreen(
    shoppingItems: List<ShoppingItem>,
    onAddItem: (name: String, quantity: Int, unit: ShoppingUnit) -> Unit,
    onRemoveItem: (itemId: String) -> Unit,
    onUpdateItemStatus: (itemId: String, purchased: Boolean) -> Unit,
) {
    val activeItems = shoppingItems.filterNot { it.isPurchased }
    val purchasedItems = shoppingItems.filter { it.isPurchased }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            AddItemForm(onAddItem = onAddItem)
        }

        if (activeItems.isNotEmpty()) {
            item {
                ShoppingSectionHeader(text = "Lista zakupów")
            }
        }

        items(activeItems, key = { it.id }) { item ->
            ShoppingItemRow(
                item = item,
                onCheckedChange = { checked -> onUpdateItemStatus(item.id, checked) },
                onDelete = { onRemoveItem(item.id) },
            )
        }

        if (purchasedItems.isNotEmpty()) {
            item {
                ShoppingSectionHeader(text = "Zakupione")
            }
        }

        items(purchasedItems, key = { it.id }) { item ->
            ShoppingItemRow(
                item = item,
                onCheckedChange = { checked -> onUpdateItemStatus(item.id, checked) },
                onDelete = { onRemoveItem(item.id) },
            )
        }
    }
}