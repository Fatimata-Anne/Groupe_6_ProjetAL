<?php

namespace App\Http\Controllers;

use App\Categorie;
use App\Article;
use Illuminate\Http\Request;

class CategorieController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $categories = Categorie::latest()->paginate(5);
  
        return view('categories.index',compact('categories'))
            ->with('i', (request()->input('page', 1) - 1) * 5);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('categories.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required'
        ]);
  
        Categorie::create($request->all());
   
        return redirect()->route('categories.index')
                        ->with('success','Categorie created successfully.');
    
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Categorie  $categorie
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $categorie= Categorie::findOrFail($id);
        $articles = $categorie->articles;
        return view('categories.show',compact('categorie','articles'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Categorie  $categorie
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        return view('categories.edit')->with(['categorie' => Categorie::find($id)]);
    
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Categorie  $categorie
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request,$id)
    
    {   
        $request->validate([
            'name' => 'required'
            
        ]);
        $categorie = Categorie::find($id);
        $categorie->name = $request->name;
        $categorie->update();
        return redirect()->route('categories.index')
        ->with('success','Categorie updated successfully');
    }
    
       


    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Categorie  $categorie
     * @return \Illuminate\Http\Response
     */
    public function destroy ($id)
    {
       
    
        Categorie::findOrFail($id)->delete();
        return redirect()->route('categories.index')
                        ->with('success','Categories deleted successfully');

  
       
    }
}
