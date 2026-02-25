package rs.nikoladeletic.dragonballencyclopedia.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rs.nikoladeletic.dragonballencyclopedia.BuildConfig
import rs.nikoladeletic.feature.home.data.remote.api.CharactersApi
import java.util.concurrent.TimeUnit

val networkModule = module {

    single(named("base_url")) {
        BuildConfig.BASE_URL
    }

    single(named("LoggingInterceptor")) {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    single(named("OkHttpClient")) {
        OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>(named("LoggingInterceptor")))
            .build()
    }

    single(named("MainRetrofit")) {
        Retrofit.Builder()
            .baseUrl(get<String>(named("base_url")))
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named("OkHttpClient")))
            .build()
    }

    single<CharactersApi> {
        get<Retrofit>(named("MainRetrofit")).create(CharactersApi::class.java)
    }

}