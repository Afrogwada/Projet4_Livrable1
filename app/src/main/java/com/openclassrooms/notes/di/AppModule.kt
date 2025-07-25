package com.openclassrooms.notes.di

import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.service.LocalNotesApiService
import com.openclassrooms.notes.service.NotesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module for providing dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotesApiService(): NotesApiService {
        return LocalNotesApiService()
    }

    @Provides
    @Singleton
    fun provideNotesRepository(apiService: NotesApiService): NotesRepository {
        return NotesRepository(apiService)
    }
}
