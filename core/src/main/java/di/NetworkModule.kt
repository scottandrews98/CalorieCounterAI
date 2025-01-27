package di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import network.NetworkClient
import network.okhttp3.Okhttp3Client
import network.retrofitClient.RetrofitClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("BaseUrl") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Named("OkHttp")
    fun provideOkHttpNetworkClient(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): NetworkClient {
        return Okhttp3Client(okHttpClient, gson)
    }

    @Provides
    @Named("Retrofit")
    fun provideRetrofitNetworkClient(retrofit: Retrofit): NetworkClient {
        return RetrofitClient(retrofit)
    }
}
