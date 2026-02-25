package rs.nikoladeletic.dragonballencyclopedia.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import rs.nikoladeletic.feature.home.ui.screens.character.CharacterViewModel
import rs.nikoladeletic.feature.home.ui.screens.home.HomeViewModel

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::CharacterViewModel)
}