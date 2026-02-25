package rs.nikoladeletic.dragonballencyclopedia.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import rs.nikoladeletic.feature.home.data.local.CharactersDatabase

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            CharactersDatabase::class.java,
            "characters_db"
        ).build()
    }

    single {
        get<CharactersDatabase>().charactersDao()
    }
}