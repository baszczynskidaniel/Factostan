package com.example.factostan.feature.facts.data.di

import com.example.factostan.core.database.FactDao
import com.example.factostan.feature.facts.data.network.ApiService
import com.example.factostan.feature.facts.data.network.FactRepositoryImpl
import com.example.factostan.feature.facts.domain.FactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FactRepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(
        apiService: ApiService,
        dao: FactDao,
    ): FactRepository = FactRepositoryImpl(apiService, dao)
}