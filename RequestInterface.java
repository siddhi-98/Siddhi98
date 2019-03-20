package com.example.sidster.apiintegration;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RequestInterface {

    @GET("test")
    Call<testPojo> test();

    @POST("user/login")
    Call<login_output_pojo> login(@Body login_input_pojo login);

    @POST("user/signup")
    Call<signin_output_pojo> signin(@Body signin_input_pojo signin);

    @POST("user/personaldetail/{id}")
    Call<personal_output> personal(@Path("id") int id,@Body personal_input personal);

    @POST("user/educationdetail/{id}")
    Call<edu_output> education(@Path("id") int id, @Body edu_input education);

    @POST("user/professionaldetail/{id}")
    Call<prof_output> prof(@Path("id")int id,@Body prof_input prof);

    @GET("user/personaldetail/{id}")
    Call<personal_output> disppersonal(@Path("id")int id);

    @GET("user/educationdetail/{id}")
    Call<edu_output> dispedu(@Path("id")int id);

    @GET("user/professionaldetail/{id}")
    Call<prof_output> dispprof(@Path("id")int id);

    @PUT("user/personaldetail/{id}")
    Call<personal_output> updatepersonal(@Path("id") int id,@Body personal_input updatepersonal);

    @PUT("user/professionaldetail/{id}")
    Call<prof_output> updateprof(@Path("id") int id, @Body prof_input updateprof);

    @PUT("user/educationdetail/{id}")
    Call<edu_output> updateedu(@Path("id")int id, @Body edu_input updatedu);

    @DELETE("user/educationdetail/{id}")
    Call<statusMessage> deleteedu(@Path("id")int id);

    @DELETE("user/professionaldetail/{id}")
    Call<statusMessage> deleteprof(@Path("id")int id);

}
