package ru.nashproject.beiny





import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.nashproject.beiny.data.MasterGetData
import ru.nashproject.beiny.data.MasterRegData
import ru.nashproject.beiny.view.logreg.activity.MainActivity


interface BeinyApi {

@GET("/name")
 fun getMastersList(): Observable<List<MasterGetData>>

 @POST("/name")
 fun registerMaster(@Body data: MasterRegData): Observable<MasterRegData>

}
val interceptor = HttpLoggingInterceptor()
    .setLevel(HttpLoggingInterceptor.Level.BODY)
val client = OkHttpClient().newBuilder().addInterceptor(interceptor)


var retrofit = Retrofit.Builder()
    .baseUrl(MainActivity.BASE_URL)
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .client(client.build())
    .build()

    var serviceBeinyApi = retrofit.create(BeinyApi::class.java)


