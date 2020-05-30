package com.example.TestMe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubApiService {

    @GET("questions")
    Call<List<Question>> getAllQuestions();

    @GET("questions/{id}")
    Call<Question> getQuestionById(@Path("id") int id);

    @POST("questions")
    Call<Question> addNewQuestion(@Body Question question);

    @GET("questions")
    Call<List<Question>> getQuestionsByCategory(@Query(value = "category") String category);

    @PUT("questions/{id}")
    Call<Question> updateQuestion(@Body Question question,@Path("id") int id);

    @DELETE("questions/{id}")
    Call<Void> deleteQuestion(@Path("id") int id);
}
