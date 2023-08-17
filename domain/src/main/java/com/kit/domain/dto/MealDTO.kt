package com.kit.domain.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.kit.domain.model.IngredientModel
import com.kit.domain.model.MealModel

@Keep

data class MealDTO(
    @SerializedName("dateModified") val dateModified: String?,
    @SerializedName("idMeal") val idMeal: String?,
    @SerializedName("strArea") val strArea: String?,
    @SerializedName("strCategory") val strCategory: String?,
    @SerializedName("strCreativeCommonsConfirmed") val strCreativeCommonsConfirmed: Any?,
    @SerializedName("strDrinkAlternate") val strDrinkAlternate: Any?,
    @SerializedName("strImageSource") val strImageSource: Any?,
    @SerializedName("strIngredient1") val strIngredient1: String?,
    @SerializedName("strIngredient10") val strIngredient10: String?,
    @SerializedName("strIngredient11") val strIngredient11: String?,
    @SerializedName("strIngredient12") val strIngredient12: String?,
    @SerializedName("strIngredient13") val strIngredient13: String?,
    @SerializedName("strIngredient14") val strIngredient14: String?,
    @SerializedName("strIngredient15") val strIngredient15: String?,
    @SerializedName("strIngredient16") val strIngredient16: String?,
    @SerializedName("strIngredient17") val strIngredient17: String?,
    @SerializedName("strIngredient18") val strIngredient18: String?,
    @SerializedName("strIngredient19") val strIngredient19: String?,
    @SerializedName("strIngredient2") val strIngredient2: String?,
    @SerializedName("strIngredient20") val strIngredient20: String?,
    @SerializedName("strIngredient3") val strIngredient3: String?,
    @SerializedName("strIngredient4") val strIngredient4: String?,
    @SerializedName("strIngredient5") val strIngredient5: String?,
    @SerializedName("strIngredient6") val strIngredient6: String?,
    @SerializedName("strIngredient7") val strIngredient7: String?,
    @SerializedName("strIngredient8") val strIngredient8: String?,
    @SerializedName("strIngredient9") val strIngredient9: String?,
    @SerializedName("strInstructions") val strInstructions: String?,
    @SerializedName("strMeal") val strMeal: String?,
    @SerializedName("strMealThumb") val strMealThumb: String?,
    @SerializedName("strMeasure1") val strMeasure1: String?,
    @SerializedName("strMeasure10") val strMeasure10: String?,
    @SerializedName("strMeasure11") val strMeasure11: String?,
    @SerializedName("strMeasure12") val strMeasure12: String?,
    @SerializedName("strMeasure13") val strMeasure13: String?,
    @SerializedName("strMeasure14") val strMeasure14: String?,
    @SerializedName("strMeasure15") val strMeasure15: String?,
    @SerializedName("strMeasure16") val strMeasure16: String?,
    @SerializedName("strMeasure17") val strMeasure17: String?,
    @SerializedName("strMeasure18") val strMeasure18: String?,
    @SerializedName("strMeasure19") val strMeasure19: String?,
    @SerializedName("strMeasure2") val strMeasure2: String?,
    @SerializedName("strMeasure20") val strMeasure20: String?,
    @SerializedName("strMeasure3") val strMeasure3: String?,
    @SerializedName("strMeasure4") val strMeasure4: String?,
    @SerializedName("strMeasure5") val strMeasure5: String?,
    @SerializedName("strMeasure6") val strMeasure6: String?,
    @SerializedName("strMeasure7") val strMeasure7: String?,
    @SerializedName("strMeasure8") val strMeasure8: String?,
    @SerializedName("strMeasure9") val strMeasure9: String?,
    @SerializedName("strSource") val strSource: String?,
    @SerializedName("strTags") val strTags: String?,
    @SerializedName("strYoutube") val strYoutube: String?
)

fun MealDTO.toMealModel() = MealModel(
    name = strMeal ?: "",
    id = idMeal ?: "",
    category = strCategory ?: "",
    area = strArea ?: "",
    imageURL = strMealThumb ?: "",
    videoURL = strYoutube ?: "",
    date = null,
    recipe = strInstructions ?: "",
    ingredients = listOf(
        if (!strIngredient1.isNullOrBlank()) {
            IngredientModel(
                strIngredient1 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient1 + ".png",
                strMeasure1 ?: ""
            )
        } else {
            null
        }, if (!strIngredient2.isNullOrBlank()) {
            IngredientModel(
                strIngredient2 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient2 + ".png",
                strMeasure2 ?: ""
            )
        } else {
            null
        }, if (!strIngredient3.isNullOrBlank()) {
            IngredientModel(
                strIngredient3 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient3 + ".png",
                strMeasure3 ?: ""
            )
        } else {
            null
        }, if (!strIngredient4.isNullOrBlank()) {
            IngredientModel(
                strIngredient4 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient4 + ".png",
                strMeasure4 ?: ""
            )
        } else {
            null
        }, if (!strIngredient5.isNullOrBlank()) {
            IngredientModel(
                strIngredient5 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient5 + ".png",
                strMeasure5 ?: ""
            )
        } else {
            null
        }, if (!strIngredient6.isNullOrBlank()) {
            IngredientModel(
                strIngredient6 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient6 + ".png",
                strMeasure6 ?: ""
            )
        } else {
            null
        }, if (!strIngredient7.isNullOrBlank()) {
            IngredientModel(
                strIngredient7 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient7 + ".png",
                strMeasure7 ?: ""
            )
        } else {
            null
        }, if (!strIngredient8.isNullOrBlank()) {
            IngredientModel(
                strIngredient8 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient8 + ".png",
                strMeasure8 ?: ""
            )
        } else {
            null
        }, if (!strIngredient9.isNullOrBlank()) {
            IngredientModel(
                strIngredient9 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient9 + ".png",
                strMeasure9 ?: ""
            )
        } else {
            null
        }, if (!strIngredient10.isNullOrBlank()) {
            IngredientModel(
                strIngredient10 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient10 + ".png",
                strMeasure10 ?: ""
            )
        } else {
            null
        }, if (!strIngredient11.isNullOrBlank()) {
            IngredientModel(
                strIngredient11 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient11 + ".png",
                strMeasure11 ?: ""
            )
        } else {
            null
        }, if (!strIngredient12.isNullOrBlank()) {
            IngredientModel(
                strIngredient12 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient12 + ".png",
                strMeasure12 ?: ""
            )
        } else {
            null
        }, if (!strIngredient13.isNullOrBlank()) {
            IngredientModel(
                strIngredient13 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient13 + ".png",
                strMeasure13 ?: ""
            )
        } else {
            null
        }, if (!strIngredient14.isNullOrBlank()) {
            IngredientModel(
                strIngredient14 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient14 + ".png",
                strMeasure14 ?: ""
            )
        } else {
            null
        }, if (!strIngredient15.isNullOrBlank()) {
            IngredientModel(
                strIngredient15 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient15 + ".png",
                strMeasure15 ?: ""
            )
        } else {
            null
        }, if (!strIngredient16.isNullOrBlank()) {
            IngredientModel(
                strIngredient16 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient16 + ".png",
                strMeasure16 ?: ""
            )
        } else {
            null
        }, if (!strIngredient17.isNullOrBlank()) {
            IngredientModel(
                strIngredient17 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient17 + ".png",
                strMeasure17 ?: ""
            )
        } else {
            null
        }, if (!strIngredient18.isNullOrBlank()) {
            IngredientModel(
                strIngredient18 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient18 + ".png",
                strMeasure18 ?: ""
            )
        } else {
            null
        }, if (!strIngredient19.isNullOrBlank()) {
            IngredientModel(
                strIngredient19 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient19 + ".png",
                strMeasure19 ?: ""
            )
        } else {
            null
        }, if (!strIngredient20.isNullOrBlank()) {
            IngredientModel(
                strIngredient20 ?: "",
                "https://www.themealdb.com/images/ingredients/" + strIngredient20 + ".png",
                strMeasure20 ?: ""
            )
        } else {
            null
        }

    )
)


