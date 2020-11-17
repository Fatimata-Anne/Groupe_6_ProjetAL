<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Article;
use App\Categorie;
class VisiteurController extends Controller
{
    public function lister(){
        $articles= Article::all();
        $categories= Categorie::all();
        return view('welcome', compact('articles','categories'));
    }

   

   


}
