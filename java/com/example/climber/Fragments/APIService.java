package com.example.climber.Fragments;

import com.example.climber.Notifications.MyResponse;
import com.example.climber.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAiApxCvU:APA91bHOTuUInEBsxpTYQnB-58J0pJINvaA-Wr4ND2aZg3fCt0p0Cg3Lq9GEAZErNqC_3JzivFnH-PZUCkI4JZtrCT3E6qh_hPjToxizijRj2rOGjRjvY7VKBbrWEo2_5xzhdgpTRPhl"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
