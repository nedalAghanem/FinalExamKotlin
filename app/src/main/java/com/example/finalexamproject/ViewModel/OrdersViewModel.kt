package com.example.finalexam.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalexam.ApiService.RetrofitClient
import com.example.finalexam.Model.Post
import kotlinx.coroutines.launch

class OrdersViewModel : ViewModel() {
    private val _posts = mutableStateOf<List<Post>>(emptyList())
    val posts: State<List<Post>> = _posts

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _posts.value = RetrofitClient.apiService.getPosts()
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Error loading posts: ${e.message}"
                _posts.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
