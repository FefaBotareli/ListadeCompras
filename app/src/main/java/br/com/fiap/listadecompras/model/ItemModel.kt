package br.com.fiap.listadecompras.model

data class ItemModel(
    val name: String,
    val onRemove: (ItemModel) -> Unit
)
