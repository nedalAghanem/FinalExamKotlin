package com.example.finalexam.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalexam.Model.OrderItem

class HomeViewModel : ViewModel() {
    private val _orderItems = MutableLiveData<List<OrderItem>>()
    val orderItems: LiveData<List<OrderItem>> = _orderItems

    init {
        loadOrders()
    }

    private fun loadOrders() {
        val items = listOf(
            OrderItem(1, "Order #1", "Pizza and Pasta", 25.99),
            OrderItem(2, "Order #2", "Burger and Fries", 18.50),
            OrderItem(3, "Order #3", "Chicken Salad", 12.75),
            OrderItem(4, "Order #4", "Steak Dinner", 32.00),
            OrderItem(5, "Order #5", "Sushi Platter", 45.99)
        )
        _orderItems.value = items
    }

    fun deleteOrder(id: Int) {
        _orderItems.value = _orderItems.value?.filter { it.id != id }
    }
}
