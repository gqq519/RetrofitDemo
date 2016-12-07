package com.feicuiedu.retrofitdemo.retrofitGet;

import com.feicuiedu.retrofitdemo.okhttpPost.User;
import com.feicuiedu.retrofitdemo.retrofitPost.UserResult;
import com.feicuiedu.retrofitdemo.retrofitTest.MultUser;

import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by gqq on 2016/12/6.
 */
// 通过注解构建请求
public interface UserRetrofitApi {
    /**
     * Retrofit使用：需要创建一个接口，构建请求，通过Retrofit的Create方法
     */

//    Request request = new Request.Builder()
//            .url(url)
//            .get()
//            .build();

    @GET("https://api.github.com/search/repositories")
    Call<ResponseBody> getData(@Query("q")String q,@Query("page")int page);

    @POST("http://admin.syfeicuiedu.com/Handler/UserHandler.ashx?action=register")
    Call<UserResult> register(@Body User user);

    /**
     * 注解：
     * 消息结构方面的注解
     * 1. 请求方式：@GET @POST
     * 2. 请求路径:url 单独讲解
     * 3. 请求头:
     *      @Headers({"Accept-Language:en","X-type:zxc","",""})添加头信息
     *      @Header("X-type")String type是在方法参数里面，动态修改添加的头信息
     * 4. 请求体：@Body User body
     * @GET @POST @Headers @Header @Body
     *
     * Url 处理方面注解
     * 1. 可替换块：https://api.github.com/repos/{owner}/{repo}
     *            @Path("owner")String owe
     *
     * 2.查询参数:https://api.github.com/search/repositories?q=language:java&page=1
     *            get请求需要动态传入查询参数的时候
     *            @Query("q")String q
     *            @QueryMap Map<String,String> map
     *
     * 3. 整合：https://api.github.com/repos/{owner}/{repo}?q=language:java&page=1
     *            可以一起使用，没有影响
     *
     * 4. 表单提交:POST https://api.github.com/search/repositories
     *                 参数a ...
     *                 参数b ...
     *               @FormUrlEncoded
     *               @Field("a")  @FieldMap Map<>
     *
     * 5. 多部分提交：@Multipart
     *               @Part("")
     *
     */

    @Headers({"Accept-Language:en","X-type:zxc","",""})
    @POST("")
    Call<ResponseBody> getA(@Header("X-type")String type, @Body User body);

    @GET("https://api.github.com/repos/{owner}/{repo}")
    Call<ResponseBody> getB(@Path("owner")String owner,@Path("repo")String repo);

    @GET("https://api.github.com/{search}/repositories")
    Call<ResponseBody> getC(@Path("search") String sear,@Query("q")String q, @Query("page")int page, @QueryMap Map<String,String> map);

    @FormUrlEncoded
    @POST("")
    Call<ResponseBody> getD(@Field("a")String a, @Field("b")String b, @FieldMap Map<String,String> map);

    @Multipart
    @POST("")
    Call<ResponseBody> getE(@Part("photo")RequestBody requestBody,@Part("username")String name);


    // 多部分
    @POST("http://wx.feicuiedu.com:9094/yitao/UserWeb?method=update")
    @Multipart
    Call<ResponseBody> getMult(@Part("user")MultUser user);


    // 表单提交
    @POST("http://wx.feicuiedu.com:9094/yitao/UserWeb?method=register")
    @FormUrlEncoded
    Call<ResponseBody> getFormUrl(@Field("username")String name,@Field("password")String password);

}
