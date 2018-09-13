package com.bramuna.bapcsales.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bramuna.bapcsales.model.DataRepository
import com.bramuna.bapcsales.model.api.PostData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel: ViewModel() {

    val sales: MutableLiveData<List<PostData>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() = compositeDisposable.clear()

    fun fetchNewestSales() {
        val disposable = DataRepository.getNewestSales()
                .subscribeOn(Schedulers.io())
                .subscribe { result -> sales.postValue(result)}
        compositeDisposable.add(disposable)
    }

    fun fetchHotestSales() {
        val disposable = DataRepository.getHotestSales()
                .subscribeOn(Schedulers.io())
                .subscribe { result -> sales.postValue(result)}
        compositeDisposable.add(disposable)
    }


}