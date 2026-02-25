package rs.nikoladeletic.dragonballencyclopedia.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import rs.nikoladeletic.feature.home.data.local.utils.NetworkCheckerImpl
import rs.nikoladeletic.feature.home.domain.repository.NetworkChecker
import rs.nikoladeletic.feature.home.ui.screens.character.CharacterViewModel
import rs.nikoladeletic.feature.home.ui.screens.home.HomeViewModel

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::CharacterViewModel)
}

val networkCheckerModule = module {
    single<NetworkChecker> {
        NetworkCheckerImpl(androidContext())
    }
}