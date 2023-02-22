package ru.nashproject.beiny





import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.nashproject.beiny.data.MasterRegData
import ru.nashproject.beiny.view.logreg.activity.MainActivity


interface BeinyApi {

@GET("/name")
 fun getMastersList(): Observable<List<MasterRegData>>

}

var retrofit = Retrofit.Builder()
    .baseUrl(MainActivity.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    var serviceBeinyApi = retrofit.create(BeinyApi::class.java)


