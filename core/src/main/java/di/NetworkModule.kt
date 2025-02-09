package di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import network.HTTPClient
import network.okhttp3.OkHttp3Client
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
    @Singleton
    fun provideOkHttp3Client(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Named("OkHttp")
    fun provideHTTPClient(
        okHttpClient: OkHttpClient,
    ): HTTPClient {
        return OkHttp3Client(okHttpClient)
    }


    @Provides
    fun provideOkHttpNetworkClient(
        okHttpClient: OkHttpClient,
    ): HTTPClient {
        return OkHttp3Client(okHttpClient)
    }

//    @Provides
//    @Named("Retrofit")
//    fun provideRetrofitNetworkClient(retrofit: Retrofit): HTTPClient {
//        return RetrofitClient(retrofit)
//    }
}
