<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('/article/listeArticle', 'ListeArticleController@index')->name('listeTousArticle'); 


Route::get('/article/ListeParCategorie', 'ListeArticleController@listArticleCategorie')->name('ListeParCategorie'); 

Route::get('/article/ChoixCategorie/{id}', 'ListeArticleController@listParChoix')->name('ListeParChoix'); 

