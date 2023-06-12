package com.example.dazninterview.di


import android.content.Context
import com.example.dazninterview.MyApp
import com.example.dazninterview.models.NasaModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return MyApp.instance.applicationContext
    }

    @Provides
    @Singleton
    fun provideCoroutineExceptionHandler(): CoroutineExceptionHandler {
        val errorHandler = CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
        }
        return errorHandler
    }

}