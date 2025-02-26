package com.hussein.baseapp.data.remote.repository

import com.hussein.baseapp.data.remote.Result
import com.hussein.baseapp.data.remote.data.DataError
import com.hussein.baseapp.domain.model.Product
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl( private val httpClient: HttpClient) : ProductRepository {
    override fun getProductList(): Flow<Result<Product, DataError.Remote>> {
        TODO("Not yet implemented")
    }
  /*  override suspend fun searchBooks(
        query: String,
        resultLimit: Int?
    ): Result<SearchResponseDto, DataError.Remote> {
        return safeCall<SearchResponseDto> {
            httpClient.get(
                urlString = "$BASE_URL/search.json"
            ) {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter("fields", "key,title,author_name,author_key,cover_edition_key,cover_i,ratings_average,ratings_count,first_publish_year,language,number_of_pages_median,edition_count")
            }
        }
    }*/
}
/*  override fun getCategories(): Flow<BaseResponse<Category>> = flow {
      emit(BaseResponse(code = 200, msg = "Loading...", status = Status.Loading))
      try {
          var categories:BaseResponse<Category> = apiService.getCategories()
          categories.let {category ->
              category.data?.let {
                  val mCategoryData = categories.copy(status = Status.Success(it) )
                  emit(mCategoryData)
              }
          }


      } catch (e: Exception) {
          emit(BaseResponse(code = 400, msg = "Error", status = Status.Error("e.message ?: Unknown error",400)))
      }
  }

/*  override fun getProperits(id:String): Flow<ArrayBaseResponse<Properity>> = flow {
      emit(ArrayBaseResponse(code = 200, msg = "Loading...", status = Status.Loading))
      try {
          var properities:ArrayBaseResponse<Properity> = apiService.getProperities(id)
          properities.let {property ->
              val mPropertyData = properities.copy(status = Status.SuccessData(property.data) )
              emit(mPropertyData)
          }
      } catch (e: Exception) {
          emit(ArrayBaseResponse(code = 400, msg = "Error", status = Status.Error("e.message ?: Unknown error",400)))
      }
  }

  override fun getOptions(id:String): Flow<ArrayBaseResponse<Option>> = flow {
      emit(ArrayBaseResponse(code = 200, msg = "Loading...", status = Status.Loading))
      try {
          var options:ArrayBaseResponse<Option> = apiService.getOptions(id)
          options.let {options ->
              val newProperity = options.data
              newProperity.add(0,Option(id = 0,name = "Other",parent = 0))
              val mOptionData = options.copy(status = Status.SuccessData(newProperity) )
              emit(mOptionData)
          }
      } catch (e: Exception) {
          emit(ArrayBaseResponse(code = 400, msg = "Error", status = Status.Error("e.message ?: Unknown error",400)))
      }
  }*/