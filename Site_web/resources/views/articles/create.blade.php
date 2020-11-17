@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Ajouter des articles </div>
                                            
                    <div class="card-body">
                
                        <form method="post" action="{{route('articles.store')}}" role="form">   
                        @csrf 
                            <div class="form-group row">
                                <label for="titre" class="col-md-6 col-form-label">{{ __('Titre') }}</label>

                                <div class="col-md-12">
                                    <input id="titre" type="text" class="form-control @error('titre') is-invalid @enderror" name="titre" 
                                    value="{{old('titre')}}"  required autocomplete="titre" autofocus>

                                    @error('titre')
                                        <span class="invalid-feedback" role="alert">
                                            <strong>{{ $message }}</strong>
                                        </span>
                                    @enderror
                                </div>
                                <label for="description" class="col-md-6 col-form-label">{{ __('Description') }}</label>
                                <div class="col-md-12">
                                    <textarea id="description" type="textarea" class="form-control @error('description') is-invalid @enderror" name="description" 
                                    value="{{old('description')}}"  required autocomplete="description" autofocus></textarea>

                                    @error('description')
                                        <span class="invalid-feedback" role="alert">
                                            <strong>{{ $message }}</strong>
                                        </span>
                                    @enderror
                                </div>


                                <label for="categorie" class="col-md-6 col-form-label">{{ __('Categorie') }}</label>
                                <div class="col-md-12">
                                    <select name="categorie" id="categorie" required autocomplete="categorie" autofocus class="form-control @error('categorie') is-invalid @enderror">
                                        @foreach ($categories as $categorie)
                                            <option value="{{ $categorie->id }}">{{ $categorie->name }}</option>
                                        @endforeach
                                    </select>

                                    @error('categorie')
                                        <span class="invalid-feedback" role="alert">
                                            <strong>{{ $message }}</strong>
                                        </span>
                                    @enderror
                                </div>

                            </div>
                                <div class="col-md-12 text-center">
                                <button type="submit" class="btn btn-success" style="color: green;">Ajouter</button></div>
                        </form>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</div>    
@endsection