package com.upm.nativeapp.di

import android.content.Context
import androidx.room.Room
import com.upm.nativeapp.common.extensions.DB_NAME
import com.upm.nativeapp.data.local.persistence.AppDao
import com.upm.nativeapp.data.local.persistence.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()

    @Provides
    fun provideDBDao(database: AppDatabase): AppDao = database.appDao()
}