package com.example.finalexam.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalexam.ApiService.RetrofitClient
import com.example.finalexam.Model.Post
import kotlinx.coroutines.launch

class OrderDetailViewModel : ViewModel() {
    private val _post = mutableStateOf<Post?>(null)
    val post: State<Post?> = _post

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    fun fetchPostById(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _post.value = RetrofitClient.apiService.getPostById(id)
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Error loading post: ${e.message}"
                _post.value = null
            } finally {
                _isLoading.value = false
            }
        }
    }
}
