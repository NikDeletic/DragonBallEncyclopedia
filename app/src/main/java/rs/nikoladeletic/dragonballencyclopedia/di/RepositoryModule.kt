package rs.nikoladeletic.dragonballencyclopedia.di

import org.koin.dsl.module
import rs.nikoladeletic.feature.home.data.remote.repository.HomeRepositoryImpl
import rs.nikoladeletic.feature.home.domain.repository.HomeRepository

val charactersRepositoryModule = module {
    single<HomeRepository> {
        HomeRepositoryImpl(get())
    }
}