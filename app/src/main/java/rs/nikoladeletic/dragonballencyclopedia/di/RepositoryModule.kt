package rs.nikoladeletic.dragonballencyclopedia.di

import org.koin.dsl.module
import rs.nikoladeletic.feature.home.data.local.repository.LocalCharactersRepositoryImpl
import rs.nikoladeletic.feature.home.data.remote.repository.HomeRepositoryImpl
import rs.nikoladeletic.feature.home.domain.repository.HomeRepository
import rs.nikoladeletic.feature.home.domain.repository.LocalCharactersRepository

val charactersRepositoryModule = module {
    single<HomeRepository> {
        HomeRepositoryImpl(get())
    }
}

val localCharactersRepositoryModule = module {
    single<LocalCharactersRepository> {
        LocalCharactersRepositoryImpl(get())
    }
}