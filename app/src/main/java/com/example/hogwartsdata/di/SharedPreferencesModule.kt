package com.example.hogwartsdata.di

import android.content.Context
import com.example.hogwartsdata.data.database.SharedPreferencesStorage
import com.example.hogwartsdata.data.network.HouseApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferencesStorage {
        return SharedPreferencesStorage(context)
    }

}