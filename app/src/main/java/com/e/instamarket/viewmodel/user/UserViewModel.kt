package com.e.instamarket.viewmodel.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.domain.Result
import com.e.domain.models.BlogModel
import com.e.domain.models.UserModel
import com.e.domain.usecase.userUseCase.GetBlogsUseCase
import com.e.domain.usecase.userUseCase.GetUserUseCase
import com.e.domain.usecase.userUseCase.UpdateUserBankInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCase: GetUserUseCase,
    private val blogsUseCase: GetBlogsUseCase,
    private val updateUserBankInfoUseCase: UpdateUserBankInfoUseCase
) : ViewModel() {

    private val _user = MutableLiveData<Result<UserModel>>()
    val user: LiveData<Result<UserModel>>
        get() = _user

    private val handler = CoroutineExceptionHandler { _, exception ->
        _user.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getUser() = viewModelScope.launch(Dispatchers.IO + handler) {
        _user.postValue(Result.Loading)
        userUseCase.execute().let {
            _user.postValue(Result.Success(it!!))
        }
    }

    private val _blogList = MutableLiveData<Result<MutableList<BlogModel>>>()
    val blogList: MutableLiveData<Result<MutableList<BlogModel>>>
        get() = _blogList

    private val blogHandler = CoroutineExceptionHandler { _, exception ->
        _blogList.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getBlogs() = viewModelScope.launch(Dispatchers.IO + blogHandler) {
        _blogList.postValue(Result.Loading)
        blogsUseCase.execute().let {
            _blogList.postValue(Result.Success(it))
        }
    }


    private val _updateUserBankInfo = MutableLiveData<Result<Boolean>>()
    val updateUserBankInfo: LiveData<Result<Boolean>>
        get() = _updateUserBankInfo

    private val updateUserBankInfoHandler = CoroutineExceptionHandler { _, exception ->
        _updateUserBankInfo.postValue(exception.message?.let { Result.Error(it) })
    }

    fun updateUserBankInfo(shcard: String, shshaba: String, bankName: String) =
        viewModelScope.launch(Dispatchers.IO + updateUserBankInfoHandler) {
            _updateUserBankInfo.postValue(Result.Loading)
            updateUserBankInfoUseCase.execute(shcard, shshaba, bankName).let {
                _updateUserBankInfo.postValue(Result.Success(it))
            }
        }

}

