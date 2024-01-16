package com.aashish.gardeningjournalapp.data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aashish.gardeningjournalapp.data.dao.PlantDao
import com.aashish.gardeningjournalapp.data.entity.Plant

@Database(
    entities = [Plant::class],
    version = 1
)
abstract class GardeningDatabase(): RoomDatabase() {
    abstract fun getPlantDao(): PlantDao

    companion object{
        @Volatile private var instance: GardeningDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =  Room.databaseBuilder(
            context.applicationContext,
            GardeningDatabase::class.java,
            "gardening"
        ).build()
    }
}