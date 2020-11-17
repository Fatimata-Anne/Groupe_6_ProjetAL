<?php

namespace App\Http\Controllers;
use Request;
use App\Article;
use App\Categorie;
class ListeArticleController extends Controller
{
    public function index(){
        return response()->json(Article::get(), 200);
    }
    
    public function listArticleCategorie(){
        return response()->json(Article::get()->groupBy('categorie_id'), 200);
    }

    public function listParChoix($id)
    {       
        return response()->json(Article::get()->where('categorie_id', '=', $id), 200);
   
    }   



   
}
