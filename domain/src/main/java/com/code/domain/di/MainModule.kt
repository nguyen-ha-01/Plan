package com.code.domain.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.code.datalayer.Database
import com.code.datalayer.constant.dbName
//import com.code.datalayer.methods.Converters
import com.code.datalayer.methods.StrategyDao
import com.code.datalayer.methods.TaskDao
import com.code.datalayer.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun getDb(@ApplicationContext context:Context): Database =
        Room.databaseBuilder(context,Database::class.java, dbName)
            .build()

    @Provides
    @Singleton
    fun getTaskDao(Db:Database): TaskDao = Db.getTaskDao()

    @Provides
    @Singleton
    fun getStrategyDao(Db: Database): StrategyDao = Db.getStrategyDao()

    @Provides
    @Singleton
    fun getMainRepository(taskDao: TaskDao,strategyDao: StrategyDao ) = MainRepository(taskDao,strategyDao)

}