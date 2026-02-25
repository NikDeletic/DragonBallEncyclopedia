package rs.nikoladeletic.dragonballencyclopedia.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import rs.nikoladeletic.feature.home.ui.HomeViewModel

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
}