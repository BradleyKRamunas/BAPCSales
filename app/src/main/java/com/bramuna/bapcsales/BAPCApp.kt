package com.bramuna.bapcsales

import android.app.Application
import com.bramuna.bapcsales.model.BaseDataRepository
import com.bramuna.bapcsales.model.DataRepository
import com.bramuna.bapcsales.model.api.RedditRepository

class BAPCApp: Application() {

    override fun onCreate() {
        super.onCreate()
        val repository: BaseDataRepository = DataRepository
        repository.init(RedditRepository())
    }
}