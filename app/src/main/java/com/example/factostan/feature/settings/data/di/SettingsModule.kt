package com.example.factostan.feature.settings.data.di

import com.example.factostan.feature.settings.domain.SettingsPreferences
import com.example.factostan.feature.settings.data.DataStoreSettings
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsModule {
    @Binds
    @Singleton
    abstract fun bindSettingsPreferences(
        impl: DataStoreSettings
    ): SettingsPreferences
}